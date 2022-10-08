import userInterface.MainUI;
import userInterface.userAuthentication.AuthProcess;

public class MainTestDrive {
    private static MainUI UI;
    private static AuthProcess authProcess;

    public static void main(String[] args) throws Exception {
        authProcess = new AuthProcess();
        UI = new MainUI();
    }
}
