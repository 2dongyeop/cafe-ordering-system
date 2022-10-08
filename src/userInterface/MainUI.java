package userInterface;

import userInterface.ApplicationException.InvalidInputException;
import userInterface.ApplicationException.SameIdException;
import userInterface.userAuthentication.AuthProcess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainUI {
    AuthProcess userAuthProcess;
    BufferedReader br;
    boolean isExited = false;

    public MainUI() {
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
                    orderDrink();
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

    private final void orderDrink() throws IOException {
        System.out.println("=====음료 주문이 시작됩니다.=====");
        System.out.println("1. 아메리카노 | 2. 카페라떼 | 3. 레몬차 | 4. 아인슈페너");

        int drinkSelect = br.read();

        /**
         * 팩토리 패턴을 이용한 음료 객체 생성 코드 작성할 곳
         */


    }

    private final void showRecommendedMenu() {

    }
}
