package pl.wedding.management.service;

public class ExceptionGeneral extends Exception {

    public ExceptionGeneral(String message) {
        super(message);
    }
    public ExceptionGeneral(String message, Throwable throwable){
        super (message, throwable);
    }
}