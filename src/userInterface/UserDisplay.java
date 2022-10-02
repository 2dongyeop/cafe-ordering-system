package userInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserDisplay {
    BufferedReader br;

    public UserDisplay() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        try {
            inputSelect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private final void inputSelect() throws Exception {
        System.out.println("=====카페 주문 시스템이 시작됩니다.=====");
        System.out.println("1. 음료 주문 | 2. 이달의 추천 메뉴 보기");

        int menuSelect = br.read();

        if (menuSelect == 1) {
            orderDrink();
        } else if (menuSelect == 2) {
            showRecommendedMenu();
        } else {
            throw new Exception("선택지는 1 또는 2만 존재합니다.");
        }
    }

    private final void orderDrink() throws IOException {
        System.out.println("=====음료 주문이 시작됩니다.=====");
        System.out.println("1. 아메리카노 | 2. 카페라떼 | 3. 레몬차 | 4. 아인슈페너");

        int drinkSelect = br.read();


    }

    private final void showRecommendedMenu() {

    }
}
