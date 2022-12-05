package com.classes.myecommerce.Exception;

public class InvalidBankInformation extends RuntimeException {
    public InvalidBankInformation(String message) {
        super(message);
    }

    public InvalidBankInformation(String message, Throwable cause) {
        super(message, cause);
    }
}