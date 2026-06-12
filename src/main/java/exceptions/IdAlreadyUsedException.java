package exceptions;

public class IdAlreadyUsedException extends RuntimeException {
    public IdAlreadyUsedException(String message) {
        super(message);
    }
}
