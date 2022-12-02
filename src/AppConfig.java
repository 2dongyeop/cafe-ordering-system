import auth.controller.AuthController;
import auth.repository.UserRepository;
import auth.service.AuthService;
import order.controller.OrderController;
import order.repository.OrderRepository;
import order.service.OrderService;

//@Configuration
public class AppConfig {

    //@Bean
    public AuthController authController() {
        return new AuthController(authService());
    }

    //@Bean
    public AuthService authService() {
        return new AuthService(userRepository());
    }

    //@Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }

    //@Bean
    public OrderController orderController() {
        return new OrderController(orderService());
    }

    //@Bean
    public OrderService orderService() {
        return new OrderService(orderRepository());
    }

    //@Bean
    public OrderRepository orderRepository() {
        return new OrderRepository();
    }
}
