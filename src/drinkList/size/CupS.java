package drinkList.size;

import drinkList.Drink;

public class CupS extends CupSize {
    public CupS(Drink drink) {
        this.drink = drink;
    }

    @Override
    public double cost() {
        return drink.cost(); // Small은 추가 비용이 없음
    }

    @Override
    public String getSize() {
        return "Small size";
    }
}
