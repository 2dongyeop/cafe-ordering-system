package drinkList.extra;

import drinkList.Drink;

public class NoCommand extends Extra {
    public NoCommand(Drink drink) {
        this.drink = drink;
    }

    /**
     * NoCommand : null object
     * 어떠한 기능도 수행하지 않지만
     * 프로그램의 안정성을 위해 삽입
     */

    public String getDescription() {
        return drink.getDescription() + "";
    }

    @Override
    public double cost() {
        return drink.cost();
    }
}
