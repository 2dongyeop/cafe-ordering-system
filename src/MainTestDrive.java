import userInterface.MainUI;
import userInterface.applicationException.InvalidInputException;
import userInterface.applicationException.SameIdException;

import java.io.IOException;

public class MainTestDrive {
    private static MainUI UI;

    public static void main(String[] args) throws InvalidInputException, IOException, SameIdException {
        UI = new MainUI();
    }
}
