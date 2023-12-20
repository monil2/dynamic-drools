package com.example.dynamicdrools.service;

import com.example.dynamicdrools.Util.ClassPathScanner;
import com.example.dynamicdrools.mapper.FlatMap;
import com.example.dynamicdrools.model.DynamicClass;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FieldAccessor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.*;

@Service
public class DynamicDroolsService {
    public List<String> getFields() {
        String packageName = "com.example.dynamicdrools.model";
        String outputDirectoryPath = "src\\main\\java";

        ClassPathScanner scanner = new ClassPathScanner(packageName, outputDirectoryPath);

        Set<Class<?>> generatedClasses = scanner.getClassesInPackage();
        List<String> fields = new ArrayList<>();

        // Extract and print fields from the generated classes
        for (Class<?> generatedClass : generatedClasses) {
            for (Field field : generatedClass.getDeclaredFields()) {
                fields.add(generatedClass.getSimpleName() + "." + field.getName());
            }
        }

        return fields;
    }

    public String instantiateClass(String json) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        DynamicClass dynamicClass = objectMapper.readValue(json, DynamicClass.class);

        String packageName = "com.example.dynamicdrools.model";
        String outputDirectoryPath = "src\\main\\java";

        ClassPathScanner scanner = new ClassPathScanner(packageName, outputDirectoryPath);

        Set<Class<?>> generatedClasses = scanner.getClassesInPackage();

        Map<String, Class<?>> fieldMap = new HashMap<>();

        generatedClasses.stream()
                .flatMap(aClass -> Arrays.stream(aClass.getDeclaredFields()))
//                .filter(field -> field.getType() == String.class || field.getType() == Boolean.class || field.getType() == Double.class)
                .forEach(field -> fieldMap.put(getFieldName(field.getDeclaringClass().getSimpleName(), field.getName()), field.getType()));

        enhanceFlatMapClass(fieldMap, dynamicClass);

        return dynamicClass.toString();
    }

    private static void enhanceFlatMapClass(Map<String, Class<?>> fieldMap, DynamicClass dynamicClass) throws Exception {
        ByteBuddy byteBuddy = new ByteBuddy();
        DynamicType.Builder<FlatMap> builder = byteBuddy.subclass(FlatMap.class);

        for (Map.Entry<String, Class<?>> entry : fieldMap.entrySet()) {
            builder = builder.defineField(entry.getKey(), entry.getValue(), Visibility.PRIVATE)
                    .defineMethod("get" + entry.getKey().substring(0, 1).toUpperCase() + entry.getKey().substring(1), entry.getValue(), Visibility.PUBLIC) // define a public getter method
                    .intercept(FieldAccessor.ofField(entry.getKey())) // use a predefined interceptor to access the field
                    .defineMethod("set" + entry.getKey().substring(0, 1).toUpperCase() + entry.getKey().substring(1), void.class, Visibility.PUBLIC) // define a public setter method
                    .withParameter(entry.getValue()) // with a parameter
                    .intercept(FieldAccessor.ofField(entry.getKey())) // use a predefined interceptor to access the field
            ;
        }

        Class<?> barClass = builder
                .withToString()
                .make()
                .load(FlatMap.class.getClassLoader())
                .getLoaded();

        // We can now create an instance of barClass and set the fields
        Object bar = barClass.getDeclaredConstructor().newInstance();

//        barClass.getMethod("mapField", Object.class, Object.class).invoke(bar, dynamicClass, bar);

        System.out.println(barClass.getMethod("toString").invoke(bar));
    }

    private static String getFieldName(String className, String fieldName) {
        return className.substring(0, 1).toLowerCase() + className.substring(1) + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }

}