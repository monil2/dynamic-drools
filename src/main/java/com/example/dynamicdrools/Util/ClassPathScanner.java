package com.example.dynamicdrools.Util;

import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;

import java.io.File;
import java.nio.file.Files;
import java.util.Set;
import java.util.stream.Collectors;

public class ClassPathScanner {
    private final String packageName;
    private final String outputDirectoryPath;

    public ClassPathScanner(String packageName, String outputDirectoryPath) {
        this.packageName = packageName;
        this.outputDirectoryPath = outputDirectoryPath;
    }

    public Set<Class<?>> getClassesInPackage() {
        ClassPathScanningCandidateComponentProvider scanner =
                new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AssignableTypeFilter(Object.class));

        return scanner.findCandidateComponents(packageName).stream()
                .map(beanDefinition -> {
                    try {
                        return Class.forName(beanDefinition.getBeanClassName());
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                })
                .filter(this::isGeneratedClass)
                .collect(Collectors.toSet());
    }

    private boolean isGeneratedClass(Class<?> clazz) {
        String generatedClassPath = outputDirectoryPath + File.separator + clazz.getName().replace(".", File.separator) + ".java";
        return Files.exists(new File(generatedClassPath).toPath());
    }
}
