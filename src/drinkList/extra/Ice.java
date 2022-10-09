package drinkList.extra;

import drinkList.Drink;

public class Ice extends Extra {
    public Ice(Drink drink) {
        this.drink = drink;
    }

    public String getDescription() {
        return drink.getDescription() + ", 얼음 추가";
    }

    @Override
    public double cost() {
        return 0.05 + drink.cost();
    }
}

