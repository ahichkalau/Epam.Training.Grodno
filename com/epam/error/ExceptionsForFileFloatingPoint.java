package com.epam.error;

public class ExceptionsForFileFloatingPoint extends Exception{
    public ExceptionsForFileFloatingPoint() {
    }

    public ExceptionsForFileFloatingPoint(String message) {
        super(message);
    }

    public ExceptionsForFileFloatingPoint(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionsForFileFloatingPoint(Throwable cause) {
        super(cause);
    }
}
