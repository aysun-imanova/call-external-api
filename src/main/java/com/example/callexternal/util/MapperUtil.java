package com.example.callexternal.util;

import java.io.IOException;
import java.io.InputStream;

import static com.example.callexternal.mapper.factory.ObjectMapperFactory.OBJECT_MAPPER_FACTORY;

public enum MapperUtil {
    MAPPER_UTIL;

    public <T> T map(InputStream body, Class<T> clazz) {
        try {
            return OBJECT_MAPPER_FACTORY.createObjectMapper().readValue(body, clazz);
        } catch (IOException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }
}
