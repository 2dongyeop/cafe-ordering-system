package drinkFactory;

import drinkList.Drink;
import drinkList.extra.Ice;
import drinkList.extra.NoCommand;
import drinkList.extra.Shot;
import drinkList.extra.Syrup;
import userInterface.applicationException.InvalidInputException;

public class OptionFactory {
    public Drink selectOption(int type, Drink drink) throws InvalidInputException {
        if (type == 1) {
            return new Ice(drink);
        } else if (type == 2) {
            return new Shot(drink);
        } else if (type == 3) {
            return new Syrup(drink);
        } else if (type == 4) {
            return new NoCommand(drink);
        }
        else {
            throw new InvalidInputException("선택지는 1부터 4까지만 가능합니다.");
        }
    }
}
