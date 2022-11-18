package order.repository.drinkEntity;

public abstract class Drink {
    String description;
    String size;

    public String getDescription() {
        return description;
    }

    public String getSize() {
        return size;
    }

    public abstract double cost();
}
