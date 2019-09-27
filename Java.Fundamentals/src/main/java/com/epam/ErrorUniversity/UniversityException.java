package com.epam.ErrorUniversity;

public class UniversityException extends Exception {

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
