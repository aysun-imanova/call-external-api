package com.example.callexternal.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@Data
@AllArgsConstructor
@JsonInclude(NON_EMPTY)
@FieldDefaults (level = AccessLevel.PRIVATE)
public class ErrorResponse {
    String code;
    String message;
}
