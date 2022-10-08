package userInterface.userAuthentication.ApplicationException;

public class SameIdException extends Exception {
    public SameIdException() {}

    public SameIdException(String message) {
        super(message);
    }
}
