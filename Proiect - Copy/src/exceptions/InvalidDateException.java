package exceptions;

public class InvalidDateException extends RuntimeException {
    public InvalidDateException(String mesaj) {
        super(mesaj);
    }
}
