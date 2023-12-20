package com.example.dynamicdrools.mapper;

import com.example.dynamicdrools.Util.ClassPathScanner;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

public class FlatMap {
    public FlatMap() {
    }

    public void mapField(Object dynamicClassObj, Object flatMapObj) {
        String packageName = "com.example.dynamicdrools.model";
        String outputDirectoryPath = "src\\main\\java";

        ClassPathScanner scanner = new ClassPathScanner(packageName, outputDirectoryPath);

        Set<Class<?>> generatedClasses = scanner.getClassesInPackage();

        generatedClasses.stream()
                .flatMap(aClass -> Arrays.stream(aClass.getDeclaredFields()))
                .forEach(field -> {
                    field.setAccessible(true);
                    try {
                        this.getClass().getMethod(getMethodName(field.getDeclaringClass().getSimpleName(), field.getName()), field.getType()).invoke(flatMapObj, field.get(dynamicClassObj));
                    } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    private static String getMethodName(String className, String fieldName) {
        return "set" + className + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }
}
