package com.example.dynamicdrools.annotation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DynamicClassDataTypes {

    STRING("STRING"),
    DATE("DATE"),
    NUMBER("NUMBER"),
    BOOLEAN("BOOLEAN"),
    OBJECT("OBJECT");

    private final String dataType;
}
