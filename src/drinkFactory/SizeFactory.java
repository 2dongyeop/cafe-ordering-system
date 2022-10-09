package drinkFactory;

import drinkList.*;
import drinkList.size.CupL;
import drinkList.size.CupM;
import drinkList.size.CupS;
import userInterface.applicationException.InvalidInputException;

public class SizeFactory {
    public Drink selectSize(int type, Drink drink) throws InvalidInputException {
        if (type == 1) {
            return new CupS(drink);
        } else if (type == 2) {
            return new CupM(drink);
        } else if (type == 3) {
            return new CupL(drink);
        } else {
            throw new InvalidInputException("선택지는 1또는 2또는 3만 가능합니다.");
        }
    }
}
