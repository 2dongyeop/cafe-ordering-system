package order.service;

import implementation.applicationException.InvalidInputException;
import order.repository.drinkEntity.Drink;
import order.front.OrderUI;
import order.repository.OrderRepository;
import order.service.drinkFactory.DrinkFactory;
import order.service.drinkFactory.OptionFactory;
import order.service.drinkFactory.SizeFactory;

import java.util.List;

public class OrderService {
    private Drink drink;
    private final OrderUI orderUI;
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        orderUI = new OrderUI();
        this.orderRepository = orderRepository;
    }

    public void createDrink(final String type) throws InvalidInputException {
        drink = DrinkFactory.createDrink(type);
    }

    public void selectDrinkSize(final String sizeSelect) throws InvalidInputException {
        drink = SizeFactory.selectSize(sizeSelect, drink);
    }

    public void selectOption(final String sizeSelect) throws InvalidInputException {
        drink = OptionFactory.selectOption(sizeSelect, drink);
    }

    public void save() {
        orderRepository.save(drink);
    }

    public void orderDetail() {
        orderUI.orderDetailUI();

        double total = 0;

        List<Drink> orderList = orderRepository.getOrderList();

        for (Drink drink: orderList) {
            orderUI.orderedDrinkUI(drink);
            total += drink.cost();
        }

        orderUI.printTotal(total);
    }
}

