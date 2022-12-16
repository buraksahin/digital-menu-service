package com.levelupcorp.emenube.util.mapper;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class GenericMapper {
    public static <S, T> void copyProperties(S source, T target) throws IllegalArgumentException, IllegalAccessException {
        if(source == null || target == null){
            return;
        }
        Field[] fields = source.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().contains("$")) {
                continue;
            }
            field.setAccessible(true);
            if(field.get(source) != null){
                try {
                    Field targetField = target.getClass().getDeclaredField(field.getName());
                    targetField.setAccessible(true);
                    targetField.set(target,field.get(source));
                } catch (NoSuchFieldException e) {
                    throw new RuntimeException(e);
                }
            }
            field.setAccessible(false);
        }
    }
}