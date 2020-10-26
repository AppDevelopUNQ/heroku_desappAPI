package ar.edu.unq.desapp.grupoa.backenddesappapi.exception;

public class InvalidIdException extends Exception {
    public InvalidIdException(Long id) {
        super("Invalid ID "+ id);
    }
}
