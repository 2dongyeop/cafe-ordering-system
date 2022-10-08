package userInterface;

import drinkFactory.DrinkFactory;
import userInterface.applicationException.InvalidInputException;
import userInterface.applicationException.SameIdException;
import userInterface.userAuthentication.AuthProcess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainUI {
    DrinkFactory drinkFactory;
    AuthProcess userAuthProcess;
    BufferedReader br;
    boolean isExited = false;

    public MainUI() {
        drinkFactory = new DrinkFactory();
        br = new BufferedReader(new InputStreamReader(System.in));

        try {
            welcomeUI();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private final void welcomeUI() throws IOException, InvalidInputException, SameIdException {
        userAuthProcess = new AuthProcess();

        do {
            System.out.println("=====카페 주문 시스템이 시작됩니다.=====");
            System.out.println("1. 음료 주문 | 2. 이달의 추천 메뉴 보기 | 3. 종료");

            int menuSelect = Integer.parseInt(br.readLine());

            switch (menuSelect) {
                case 1:
                    orderProcess();
                    break;
                case 2:
                    showRecommendedMenu();
                    break;
                case 3:
                    isExited = true;
                    break;
                default:
                    throw new InvalidInputException("선택지는 1 또는 2또는 3만 존재합니다.");
            }
        } while (!isExited);
    }

    private final void orderProcess() throws IOException {
        /**
         * 템플릿 메소드 패턴 적용
         */
        selectDrink();
        selectCupSize();
        selectOptions();
    }

    private final void selectDrink() throws IOException {
        System.out.println("=====음료 주문이 시작됩니다.=====");
        System.out.println("1. 아메리카노 | 2. 카페라떼 | 3. 레몬차 | 4. 아인슈페너");

        int drinkSelect = Integer.parseInt(br.readLine());
        /**
         * 팩토리 메소드 패턴을 이용한 음료 생성
         */
        drinkFactory.createDrink(drinkSelect);
    }

    private final void selectCupSize() {

    }

    private final void selectOptions() {

    }

    private final void showRecommendedMenu() {

    }
}
