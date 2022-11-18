package order.repository;

import order.repository.drinkEntity.Drink;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private List<Drink> orderList;

    public OrderRepository() {
        orderList = new ArrayList<>();
    }

    public void save(Drink drink) {
        orderList.add(drink);
    }

    public List<Drink> getOrderList() {
        return orderList;
    }
}
