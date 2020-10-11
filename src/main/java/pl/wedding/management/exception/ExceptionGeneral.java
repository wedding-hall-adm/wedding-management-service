package pl.wedding.management.exception;

public class ExceptionGeneral extends RuntimeException {

    public ExceptionGeneral(String message) {
        super(message);
    }

    public ExceptionGeneral(String message, Throwable throwable) {
        super(message, throwable);
    }
}