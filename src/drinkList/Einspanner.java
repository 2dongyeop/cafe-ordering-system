package drinkList;

public class Einspanner extends Drink {
    public Einspanner() {
        description = "어른들의 아인슈페너";
    }

    @Override
    public double cost() {
        return 4.5;
    }
}
