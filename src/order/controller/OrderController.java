package order.controller;

import implementation.applicationException.InvalidInputException;
import implementation.enumeration.LastOrderSelect;
import implementation.singleton.SingletonBufferedReader;
import order.front.OrderUI;
import order.service.OrderService;

import java.io.IOException;

public class OrderController {
    private final OrderUI orderUI;
    private final OrderService orderService;
    private final SingletonBufferedReader br;
    private boolean isExited = false;

    public OrderController(OrderService orderService) {
        orderUI = new OrderUI();
        this.orderService = orderService;
        br = SingletonBufferedReader.getInstance();
    }

    public void start() {
        orderUI.welcome();

        while (!isExited) {
            createDrink();
            selectDrinkSize();
            selectOptions();
            askForLastOrder();
        }

        orderService.orderDetail();
    }

    private void createDrink() {
        orderUI.createDrinkUI();

        try {
            orderService.createDrink(br.readLine());
        } catch (ClassCastException | InvalidInputException e) {
            orderUI.invalidInput();
        } catch (IOException e) {}
    }

    private void selectDrinkSize() {
        orderUI.selectDrinkSizeUI();

        try {
            orderService.selectDrinkSize(br.readLine());
        } catch (ClassCastException | InvalidInputException e) {
            orderUI.invalidInput();
        } catch (IOException e) {}
    }

    private void selectOptions() {
        boolean isLastOption = false;

        while (!isLastOption) {
            orderUI.selectOptionsUI();

            try {
                String sizeSelect = br.readLine();
                orderService.selectOption(sizeSelect);

                isLastOption = (sizeSelect.equals("4"));
            } catch (ClassCastException | InvalidInputException | NumberFormatException e) {
                orderUI.invalidInput();
            } catch (IOException e) {}
        }
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