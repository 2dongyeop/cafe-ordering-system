package order.service.drinkFactory;

import order.repository.drinkEntity.*;
import order.repository.sizeEntity.CupL;
import order.repository.sizeEntity.CupM;
import order.repository.sizeEntity.CupS;
import implementation.applicationException.InvalidInputException;

public class SizeFactory {
    public static Drink selectSize(int type, Drink drink) throws InvalidInputException {
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
