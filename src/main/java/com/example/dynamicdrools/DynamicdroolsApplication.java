package com.example.dynamicdrools;

import com.example.dynamicdrools.annotation.DynamicClassDataTypes;
import com.example.dynamicdrools.annotation.DynamicClassField;
import com.example.dynamicdrools.mapper.FlatMap;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class DynamicdroolsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DynamicdroolsApplication.class, args);
    }

    public static Class<?> generateDynamicClass(String jsonSchema) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode schemaNode = objectMapper.readTree(jsonSchema);

        // Use Byte Buddy to create a dynamic class

        DynamicType.Builder<?> builder = new ByteBuddy().subclass(FlatMap.class);

        builder = createFields(builder, schemaNode, "");

        Class<?> dynamicClass = builder
                .withToString()
                .make()
                .load(FlatMap.class.getClassLoader())
                .getLoaded();
        return dynamicClass;
    }

    private static DynamicType.Builder<?> createFields(DynamicType.Builder<?> builder, JsonNode node, String parentField) {
        final DynamicType.Builder<?>[] b = {builder};
        if (node.isObject()) {
            node.fields().forEachRemaining(entry -> {
                String fieldName = entry.getKey();
                JsonNode fieldValue = entry.getValue();
                String fullPath = parentField.isEmpty() ? fieldName : parentField + "_" + fieldName;
                if (fieldValue.isObject()) {
                    b[0] = createFields(b[0], fieldValue, fullPath);
                } else {
                    b[0] = b[0].defineField(fullPath, String.class, Visibility.PRIVATE)
                            .annotateField(AnnotationDescription.Builder.ofType(DynamicClassField.class)
                                    .define("fullName", fullPath)
                                    .define("dataType", getFieldDataType(fieldValue))
                                    .build())
                    ;
                }
            });
        }
        return b[0];
    }

    private static DynamicClassDataTypes getFieldDataType(JsonNode fieldValue) {
        String dataType = fieldValue.getNodeType().name();
        return DynamicClassDataTypes.valueOf(dataType);
    }

    private static void instantiateFields(JsonNode node, String parentField, Object flatMap, Class<?> dynamicClass) {
        if (node.isObject()) {
            node.fields().forEachRemaining(entry -> {
                String fieldName = entry.getKey();
                JsonNode fieldValue = entry.getValue();
                String fullPath = parentField.isEmpty() ? fieldName : parentField + "_" + fieldName;
                if (fieldValue.isObject()) {
                    instantiateFields(fieldValue, fullPath, flatMap, dynamicClass);
                } else {
                    try {
                        Field field = dynamicClass.getDeclaredField(fullPath);
                        field.setAccessible(true);
                        field.set(flatMap, fieldValue.textValue());
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }

    private static Class<?> getFieldType(JsonNode node) {
        if (node.isNumber()) {
            return Double.class;
        } else if (node.isTextual()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                dateFormat.parse(node.textValue());
                return Date.class;
            } catch (ParseException e) {
                return String.class;
            }
        } else if (node.isBoolean()) {
            return Boolean.class;
        } else {
            return Object.class;
        }
    }

    @Override
    public void run(String... args) throws Exception {
        String jsonSchema = "{\"name\":\"John\",\"address\":{\"city\":\"NY\",\"country\":\"USA\"}}";
        Class<?> dynamicClass = generateDynamicClass(jsonSchema);

        Object flatMap = dynamicClass.getDeclaredConstructor().newInstance();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(jsonSchema);

        instantiateFields(jsonNode, "", flatMap, dynamicClass);

        Arrays.stream(dynamicClass.getDeclaredFields()).forEach(field -> System.out.println(field.getName()
                + " " + field.getAnnotation(DynamicClassField.class).fullName()
                + " " + field.getAnnotation(DynamicClassField.class).dataType().getDataType()));

        System.out.println(dynamicClass.getMethod("toString").invoke(flatMap));
    }
}
