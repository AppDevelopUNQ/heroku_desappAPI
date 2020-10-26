package ar.edu.unq.desapp.grupoa.backenddesappapi.exception;

public class InvalidLogInException extends Exception {
    public InvalidLogInException(String msg) {
        super("Invalid Email or password"+ msg);
    }
}
