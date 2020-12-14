package dev.exception;

public class PlatException extends RuntimeException {

    public PlatException() {
    }

    public PlatException(String message) {
        super(message);
    }

    public PlatException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlatException(Throwable cause) {
        super(cause);
    }

    public PlatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
