package drinkList;

public abstract class Drink {
    String description;

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
