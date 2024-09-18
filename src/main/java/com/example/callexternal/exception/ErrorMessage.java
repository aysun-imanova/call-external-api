package com.example.callexternal.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorMessage {
    STATISTICS_NOT_FOUND_EXCEPTION("STATISTICS_NOT_FOUND_EXCEPTION", "Statistics not found"),
    UNEXPECTED_EXCEPTION("UNEXPECTED_EXCEPTION", "Unexpected exception occurred"),
    CLIENT_EXCEPTION("CLIENT_EXCEPTION", "Client exception occurred");

    String code;
    String message;
}
