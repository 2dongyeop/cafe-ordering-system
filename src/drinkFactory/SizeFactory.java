package drinkFactory;

import drinkList.*;
import drinkList.size.CupL;
import drinkList.size.CupM;
import drinkList.size.CupS;
import userInterface.applicationException.InvalidInputException;

public class SizeFactory {
    public Drink selectSize(int type, Drink drink) throws InvalidInputException {
        drink = switch (type) {
            case 1 -> {
                yield new CupS(drink);
            }
            case 2 -> {
                yield new CupM(drink);
            }
            case 3 -> {
                yield new CupL(drink);
            }
            default -> throw new InvalidInputException("1부터 3까지만 입력 가능합니다.");
        };
        return drink;
    }
}
