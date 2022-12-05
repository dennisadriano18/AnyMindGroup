package com.classes.myecommerce.Exception;

public class InvalidCourierException extends RuntimeException {
    public InvalidCourierException(String message) {
        super(message);
    }

    public InvalidCourierException(String message, Throwable cause) {
        super(message, cause);
    }
}