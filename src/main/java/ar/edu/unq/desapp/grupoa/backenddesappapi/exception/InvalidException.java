package ar.edu.unq.desapp.grupoa.backenddesappapi.exception;

public class InvalidException extends Exception {
    public InvalidException(String msg) {
        super("invalid: " + msg);
    }
}
