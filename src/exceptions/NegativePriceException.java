package exceptions;

public class NegativePriceException extends RuntimeException {
    public NegativePriceException() {
        super("Negative price.");
    }

    public NegativePriceException(String message) {
        super(message);
    }
}