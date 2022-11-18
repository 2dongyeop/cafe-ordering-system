package order.repository.drinkEntity;

public class Latte extends Drink {
    public Latte() {
        description = "달~달한 라떼";
    }

    @Override
    public double cost() {
        return 5.5;
    }
}
