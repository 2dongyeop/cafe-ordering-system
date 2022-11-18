package order.repository.optionEntity;

import order.repository.drinkEntity.Drink;

public class Shot extends Extra {
    public Shot(Drink drink) {
        this.drink = drink;
    }

    public String getDescription() {
        return drink.getDescription() + ", 샷 추가";
    }

    @Override
    public double cost() {
        return 0.5 + drink.cost();
    }
}
