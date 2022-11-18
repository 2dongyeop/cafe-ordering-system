package order.repository.drinkEntity;

public class LemonTee extends Drink {
    public LemonTee() {
        description = "상~콤한 레몬차";
    }

    @Override
    public double cost() {
        return 6.0;
    }
}
