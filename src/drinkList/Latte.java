package drinkList;

public class Latte extends Drink {
    public Latte() {
        description = "달~달한 카페라떼";
    }

    @Override
    public double cost() {
        return 5.5;
    }
}
