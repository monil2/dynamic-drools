package com.example.dynamicdrools.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DynamicClassField {
    String fullName() default "DEFAULT_FULL_NAME";

    DynamicClassDataTypes dataType() default DynamicClassDataTypes.STRING;

    String[] possibleValues() default {};
}
