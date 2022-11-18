package order.repository.drinkEntity;

public class Americano extends Drink {
    public Americano() {
        description = "시~원한 아메리카노";
    }

    @Override
    public double cost() {
        return 5.0;
    }
}
