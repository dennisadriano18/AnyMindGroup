package com.classes.myecommerce.Exception;

public class InvalidPriceModifier extends RuntimeException {
    public InvalidPriceModifier(String message) {
        super(message);
    }

    public InvalidPriceModifier(String message, Throwable cause) {
        super(message, cause);
    }
}
