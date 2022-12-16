package com.levelupcorp.emenube.util.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

@Component
public class DataConverter {
    private static final Gson gson = new GsonBuilder().serializeNulls().create();

    public String toJson(Object o) {
        return gson.toJson(o);
    }

    public <T> T toObject(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }
}
