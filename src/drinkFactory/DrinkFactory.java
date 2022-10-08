package drinkFactory;

import drinkList.*;

public class DrinkFactory {
    public Drink createDrink(int type) {
        Drink drink = null;

        if (type == 1) {
            drink = new Americano();
        } else if (type == 2) {
            drink = new Latte();
        } else if (type == 3) {
            drink = new LemonTee();
        } else if (type == 4) {
            drink = new Einspanner();
        }

        return drink;
    }
}
