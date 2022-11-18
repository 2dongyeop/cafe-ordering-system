import auth.controller.AuthController;
import order.controller.OrderController;

public class MainTestDrive {
    private AuthController authController;
    private OrderController orderController;

    public MainTestDrive() {
        authController = new AuthController();
        orderController = new OrderController();
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
