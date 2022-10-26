package userInterface.recommendProcess;

import drinkFactory.DrinkFactory;
import drinkList.Drink;
import userInterface.applicationException.InvalidInputException;

import java.util.Random;


public class RecommendProcess {
    Drink recommendedDrink;
    DrinkFactory drinkFactory;

    public RecommendProcess() throws InvalidInputException {
        drinkFactory = new DrinkFactory();
        Random random = new Random();

        int randomNumber = random.nextInt(3) + 1;
        recommendedDrink = drinkFactory.createDrink(randomNumber);
    }

    public Drink getRecommendedDrink() {
        return recommendedDrink;
    }
}
