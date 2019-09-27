package com.epam.collections.taxiStation.taxiException;

public class TaxiStationException extends Exception{
    public TaxiStationException() {
    }

    public TaxiStationException(String message) {
        super(message);
    }

    public TaxiStationException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaxiStationException(Throwable cause) {
        super(cause);
    }

    public TaxiStationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
