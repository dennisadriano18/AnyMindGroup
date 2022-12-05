package com.classes.myecommerce.Exception;

public class InvalidPaymentMethod extends RuntimeException {
    public InvalidPaymentMethod(String message) {
        super(message);
    }

    public InvalidPaymentMethod(String message, Throwable cause) {
        super(message, cause);
    }
}
