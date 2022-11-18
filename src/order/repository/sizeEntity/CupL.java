package order.repository.sizeEntity;

import order.repository.drinkEntity.Drink;

public class CupL extends CupSize {
    public CupL(Drink drink) {
        this.drink = drink;
    }

    @Override
    public double cost() {
        return 0.1 + drink.cost(); // Medium은 1000원 추가
    }

    @Override
    public String getSize() {
        return "Large size";
    }
}
