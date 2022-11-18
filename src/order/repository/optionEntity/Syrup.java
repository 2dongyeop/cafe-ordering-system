package order.repository.optionEntity;

import order.repository.drinkEntity.Drink;

public class Syrup extends Extra {
    public Syrup(Drink drink) {
        this.drink = drink;
    }

    public String getDescription() {
        return drink.getDescription() + ", 시럽 추가";
    }

    @Override
    public double cost() {
        return 0.05 + drink.cost();
    }
}
