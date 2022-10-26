package drinkFactory;

import drinkList.*;
import userInterface.applicationException.InvalidInputException;

public class DrinkFactory {
    public final Drink createDrink(final int type) throws InvalidInputException {
        Drink drink = switch (type) {
            case 1 -> {
                yield new Americano();
            }
            case 2 -> {
                yield new Latte();
            }
            case 3 -> {
                yield new LemonTee();
            }
            case 4 -> {
                yield new Einspanner();
            }
            default -> throw new InvalidInputException("1부터 4까지만 입력 가능합니다.");
        };
        return drink;
    }
}
