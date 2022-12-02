package order.controller;

import implementation.applicationException.InvalidInputException;
import implementation.enumeration.LastOrderSelect;
import implementation.singleton.SingletonBufferedReader;
import order.front.OrderUI;
import order.service.OrderService;

import java.io.IOException;

public class OrderController {
    private OrderUI orderUI;
    private OrderService orderService;
    private SingletonBufferedReader br;
    private boolean isExited = false;

    public OrderController(OrderService orderService) {
        orderUI = new OrderUI();
        this.orderService = orderService;
        br = SingletonBufferedReader.getInstance();
    }

    public void start() {
        orderUI.welcome();

        do {

            createDrink();
            selectDrinkSize();
            selectOptions();
            askForLastOrder();
        } while (!isExited);

        orderService.orderDetail();
    }

    private void createDrink() {
        orderUI.createDrinkUI();

        try {
            int drinkSelect = Integer.parseInt(br.readLine());

            orderService.createDrink(drinkSelect);
        } catch (ClassCastException | InvalidInputException e) {
            orderUI.invalidInput();
        } catch (IOException e) {}
    }

    private void selectDrinkSize() {
        orderUI.selectDrinkSizeUI();

        try {
            int sizeSelect = Integer.parseInt(br.readLine());

            orderService.selectDrinkSize(sizeSelect);
        } catch (ClassCastException | InvalidInputException e) {
            orderUI.invalidInput();
        } catch (IOException e) {}
    }

    private void selectOptions() {

        boolean isLastOption = false;
        do {
            orderUI.selectOptionsUI();

            try {
                int sizeSelect = Integer.parseInt(br.readLine());

                if (sizeSelect > 0 && sizeSelect < 5) {

                    orderService.selectOption(sizeSelect);

                    if (sizeSelect == 4) isLastOption = true;
                } else
                    throw new InvalidInputException();
            } catch (ClassCastException | InvalidInputException | NumberFormatException e) {
                orderUI.invalidInput();
            } catch (IOException e) {}
        } while (!isLastOption);
    }

    public void askForLastOrder() {
        orderUI.askForLastOrderUI();

        try {
            switch (LastOrderSelect.transform(br.readLine())) {
                case ADDITIONAL_ORDER -> {
                    orderService.save();
                }
                case EXIT -> {
                    orderService.save();
                    isExited = true;
                }
                default -> throw new InvalidInputException();
            }
        } catch (ClassCastException | InvalidInputException e) {
            orderUI.invalidInput();
        } catch (IOException e) {}
    }
}
