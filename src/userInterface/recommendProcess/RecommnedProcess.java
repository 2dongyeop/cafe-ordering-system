package userInterface.recommendProcess;

import drinkFactory.DrinkFactory;
import drinkList.Drink;
import userInterface.applicationException.InvalidInputException;

import java.util.Random;


public class RecommnedProcess {
    Drink recommendedDrink;
    DrinkFactory drinkFactory;

    public RecommnedProcess() throws InvalidInputException {
        drinkFactory = new DrinkFactory();
        Random random = new Random();

        int randomNumber = random.nextInt(3) + 1;
        recommendedDrink = drinkFactory.createDrink(randomNumber);
    }

    public Drink getRecommendedDrink() {
        return recommendedDrink;
    }
}
