package order.repository.sizeEntity;

import order.repository.drinkEntity.Drink;

public abstract class CupSize extends Drink {
    Drink drink;

    public abstract String getSize();

    public String getDescription() {
        return drink.getDescription();
    }
}
