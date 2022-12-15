import auth.controller.AuthController;
import order.controller.OrderController;

public class MainTestDrive {
    private final AppConfig appConfig;
    private final AuthController authController;
    private final OrderController orderController;

    public MainTestDrive() {
        appConfig = new AppConfig();
        authController = appConfig.authController();
        orderController = appConfig.orderController();
    }

    public static void main(String[] args){
        MainTestDrive testDrive = new MainTestDrive();
        testDrive.start();
    }

    private void start(){
        authController.start();
        orderController.start();
    }
}
