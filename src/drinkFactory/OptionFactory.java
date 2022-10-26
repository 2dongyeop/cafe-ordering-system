package drinkFactory;

import drinkList.*;
import drinkList.extra.Ice;
import drinkList.extra.NoCommand;
import drinkList.extra.Shot;
import drinkList.extra.Syrup;
import userInterface.applicationException.InvalidInputException;

public class OptionFactory {
    public Drink selectOption(int type, Drink drink) throws InvalidInputException {
        drink = switch (type) {
            case 1 -> {
                yield new Ice(drink);
            }
            case 2 -> {
                yield new Shot(drink);
            }
            case 3 -> {
                yield new Syrup(drink);
            }
            case 4 -> {
                yield new NoCommand(drink);
            }
            default -> throw new InvalidInputException("1부터 4까지만 입력 가능합니다.");
        };
        return drink;
    }
}
