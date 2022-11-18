package order.repository.sizeEntity;

import order.repository.drinkEntity.Drink;

public class CupM extends CupSize {
    public CupM(Drink drink) {
        this.drink = drink;
    }

    @Override
    public double cost() {
        return 0.05 + drink.cost(); // Medium은 500원 추가
    }

    @Override
    public String getSize() {
        return "Medium size";
    }
}
