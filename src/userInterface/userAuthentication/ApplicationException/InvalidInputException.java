package userInterface.userAuthentication.ApplicationException;

public class InvalidInputException extends Exception {
    public InvalidInputException() {}

    public InvalidInputException(String message) {
        super(message);
    }
}
