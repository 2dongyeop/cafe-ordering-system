import auth.controller.AuthController;
import order.controller.OrderController;

public class MainTestDrive {
    private AppConfig appConfig = new AppConfig();
    private AuthController authController;
    private OrderController orderController;

    public MainTestDrive() {
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
