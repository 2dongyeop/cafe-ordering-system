package order.repository.optionEntity;

import order.repository.drinkEntity.Drink;

public abstract class Extra extends Drink {
    Drink drink;

    public abstract String getDescription();

    public String getSize() {
        return drink.getSize();
    }
}
