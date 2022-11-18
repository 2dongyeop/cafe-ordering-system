package implementation.applicationException;

public class SameIdException extends Exception {
    public SameIdException() {}

    public SameIdException(String message) {
        super(message);
    }
}
