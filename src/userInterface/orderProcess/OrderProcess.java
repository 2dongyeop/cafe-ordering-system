package userInterface.orderProcess;

import drinkFactory.DrinkFactory;
import drinkFactory.OptionFactory;
import drinkFactory.SizeFactory;
import drinkList.Drink;
import enumeration.LastOrderSelect;
import userInterface.SingletonBufferedReader;
import userInterface.applicationException.InvalidInputException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderProcess {
    Drink drink;
    List<Drink> orderList;
    SizeFactory sizeFactory;
    DrinkFactory drinkFactory;
    OptionFactory optionFactory;
    SingletonBufferedReader br;
    boolean isExited = false;

    public OrderProcess() {
        orderList = new ArrayList<>();
        sizeFactory = new SizeFactory();
        drinkFactory = new DrinkFactory();
        optionFactory = new OptionFactory();
        br = SingletonBufferedReader.getInstance();
    }

    public void start() throws InvalidInputException, IOException {
        /**
         * 템플릿 메소드
         */
        do {
            selectDrink();
            selectCupSize();
            selectOptions();
            askForAdditionalOrder();
        } while (!isExited);
    }

    public Drink getDrink() {
        return drink;
    }

    public List getOrderList() { return orderList; }

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

    private void askForAdditionalOrder() throws IOException {
        System.out.println("===== 다른 음료를 추가로 주문하시겠습니까? =====");
        System.out.println("추가 주문하기 : 1을 입력 | 주문 끝내기 : 2를 입력");

        try {
            switch (LastOrderSelect.transform(br.readLine())) {
                case ADDITIONALORDER -> {
                    drink = getDrink();
                    orderList.add(drink);
                }
                case EXIT -> {
                    drink = getDrink();
                    orderList.add(drink);
                    isExited = true;
                }
                default -> throw new InvalidInputException();
            }
        } catch (ClassCastException | InvalidInputException e) {
            System.out.println("입력은 1과 2만 가능합니다.");
        }
    }
}
