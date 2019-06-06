package exceptions;

public class InstatiationExceededException extends RuntimeException {
    public InstatiationExceededException(String mesaj) {
        super(mesaj);
    }
}