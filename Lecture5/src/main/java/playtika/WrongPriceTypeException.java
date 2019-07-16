package playtika;

public class WrongPriceTypeException extends RuntimeException {
    public WrongPriceTypeException(String message) {
        super(message);
    }
}