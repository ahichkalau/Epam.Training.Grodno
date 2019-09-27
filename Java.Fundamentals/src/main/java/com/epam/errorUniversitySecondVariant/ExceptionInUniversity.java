package com.epam.errorUniversitySecondVariant;

public class ExceptionInUniversity extends Exception {
    public ExceptionInUniversity() {
    }

    public ExceptionInUniversity(String message) {
        super(message);
    }

    public ExceptionInUniversity(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionInUniversity(Throwable cause) {
        super(cause);
    }
}
