package com.example.exception;

import lombok.Getter;

import java.util.Map;

public class ShopException extends RuntimeException {
    @Getter
    private final Map<String, String> errors;

    public ShopException(ShopExceptionType exceptionType) {
        this.errors = exceptionType.getMap();
    }
}
