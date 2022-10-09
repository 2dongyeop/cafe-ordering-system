package drinkFactory;

import drinkList.*;
import userInterface.applicationException.InvalidInputException;

public class DrinkFactory {
    public Drink createDrink(int type) throws InvalidInputException {
        Drink drink;

        if (type == 1) {
            drink = new Americano();
        } else if (type == 2) {
            drink = new Latte();
        } else if (type == 3) {
            drink = new LemonTee();
        } else if (type == 4) {
            drink = new Einspanner();
        } else {
            throw new InvalidInputException("입력은 1부터 4까지의 정수만 가능합니다");
        }

        return drink;
    }
}
