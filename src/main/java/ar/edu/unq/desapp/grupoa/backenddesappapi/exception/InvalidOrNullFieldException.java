package ar.edu.unq.desapp.grupoa.backenddesappapi.exception;

public class InvalidOrNullFieldException extends Exception {
    public InvalidOrNullFieldException(String fieldName) {
        super("Invalid value or non existing field: "+ fieldName);
    }
}
