package com.classes.myecommerce.Exception;

public class InvalidLast4Exception extends RuntimeException {
    public InvalidLast4Exception(String message) {
        super(message);
    }

    public InvalidLast4Exception(String message, Throwable cause) {
        super(message, cause);
    }
}
