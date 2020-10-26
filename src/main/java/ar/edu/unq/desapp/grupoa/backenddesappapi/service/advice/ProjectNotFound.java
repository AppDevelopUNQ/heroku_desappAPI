package ar.edu.unq.desapp.grupoa.backenddesappapi.service.advice;

import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidIdException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProjectNotFound {

    @ResponseBody
    @ExceptionHandler(InvalidIdException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String invalidIdExceptionHandler(InvalidIdException ex) {
        return ex.getMessage();
    }

}
