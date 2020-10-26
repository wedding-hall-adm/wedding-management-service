package pl.wedding.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ExceptionControllerAdvice {


    @ResponseBody
    @ExceptionHandler(ExceptionGeneral.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFoundData(String data) {
        return String.format("The data %s not found", data);
    }
}
