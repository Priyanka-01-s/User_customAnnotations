package com.example;

import com.annotations.*;
import java.lang.reflect.Field;


public class Validation {
    public static void validate(Object ob){
        Field[] fields = ob.getClass().getDeclaredFields();

        for(Field field : fields){
            field.setAccessible(true);
            if (field.isAnnotationPresent(NotBlank.class)) {
                validateNotBlank(ob, field);
            }
            if (field.isAnnotationPresent(Positive.class)) {
                validatePositive(ob, field);
            }
        }
    }

    public static void validateNotBlank(Object ob, Field field){
        try{
            Object value = field.get(ob);
            if (value == null || (value instanceof String && ((String) value).trim().isEmpty())) {
                throw new ValiadationException(field.getName() + " must not be blank.");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace(); 
        }
        
    }

    private static void validatePositive(Object ob, Field field) {
        try {
            Object value = field.get(ob);
            if (value != null) {
                if (value instanceof Number) {
                    double numericValue = ((Number) value).doubleValue();
                    if (numericValue <= 0) {
                        throw new ValiadationException(field.getName() + " must be positive.");
                    }
                } else {
                    throw new ValiadationException(field.getName() + " must be a numeric type.");
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace(); 
        }
    }
}
