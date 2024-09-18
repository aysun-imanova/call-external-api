package com.example.callexternal.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NotFoundException extends RuntimeException {
    String code;

    public NotFoundException(String message, String code) {
        super(message);
        this.code = code;
    }
}
