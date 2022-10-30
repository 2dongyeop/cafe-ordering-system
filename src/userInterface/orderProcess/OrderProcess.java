package userInterface.orderProcess;

import drinkFactory.DrinkFactory;
import drinkFactory.OptionFactory;
import drinkFactory.SizeFactory;
import drinkList.Drink;
import userInterface.applicationException.InvalidInputException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderProcess {
    Drink drink;
    SizeFactory sizeFactory = new SizeFactory();
    DrinkFactory drinkFactory = new DrinkFactory();
    OptionFactory optionFactory = new OptionFactory();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public OrderProcess() {}

    public void start() throws InvalidInputException, IOException {
        /**
         * 템플릿 메소드
         */
        selectDrink();
        selectCupSize();
        selectOptions();
    }

    public Drink getDrink() {
        return drink;
    }

    private void selectDrink() throws IOException, InvalidInputException {
        System.out.println("=====음료 주문이 시작됩니다.=====");
        System.out.println("1. 아메리카노 | 2. 카페라떼 | 3. 레몬차 | 4. 아인슈페너");

        try {
            int drinkSelect = Integer.parseInt(br.readLine());
            /**
             * 팩토리 패턴을 이용한 음료 생성
             */
            drink = drinkFactory.createDrink(drinkSelect);
        } catch (ClassCastException e) {
            System.out.println("입력은 정수만 가능합니다.");
        }
    }

    private void selectCupSize() throws IOException, InvalidInputException {
        System.out.println("=====음료 사이즈를 선택하세요.=====");
        System.out.println("1. Small | 2. Medium | 3. Large");

        try {
            int sizeSelect = Integer.parseInt(br.readLine());

            drink = sizeFactory.selectSize(sizeSelect, drink);
        } catch (ClassCastException e) {
            System.out.println("입력은 정수만 가능합니다.");
        }
    }

    private void selectOptions() throws IOException, InvalidInputException {
        boolean isEnded = false;
        //옵션은 여러 번을 추가할 수 있다.
        do {
            System.out.println("=====추가 옵션을 선택하세요.=====");
            System.out.println("1. Ice | 2. Shot | 3. Syrup | 4. [Do Not add Option]");

            try {
                int sizeSelect = Integer.parseInt(br.readLine()); //ClassCastException

                if (sizeSelect > 0 && sizeSelect < 5) {
                    drink = optionFactory.selectOption(sizeSelect, drink);
                    if (sizeSelect == 4) isEnded = true;
                } else
                    throw new InvalidInputException("1부터 4까지만 입력 가능합니다.");
            } catch (ClassCastException e) {
                System.out.println("입력은 정수만 가능합니다.");
            }
        } while (!isEnded);
    }
}
