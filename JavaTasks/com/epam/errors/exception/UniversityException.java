package com.epam.errors.exception;

public class UniversityException extends Exception{

    public UniversityException() {
    }

    public UniversityException(String message) {
        super(message);
    }

    public UniversityException(String message, Throwable cause) {
        super(message, cause);
    }

    public UniversityException(Throwable cause) {
        super(cause);
    }
}

