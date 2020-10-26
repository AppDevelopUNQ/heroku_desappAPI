package ar.edu.unq.desapp.grupoa.backenddesappapi.exception;

public class MailValidation extends Exception {
    public MailValidation() {
        super("The mail is not valid, please retry!");
    }
}
