package userInterface;

import drinkFactory.DrinkFactory;
import drinkFactory.OptionFactory;
import drinkFactory.SizeFactory;
import drinkList.Drink;
import userInterface.applicationException.InvalidInputException;
import userInterface.applicationException.SameIdException;
import userInterface.orderProcess.OrderProcess;
import userInterface.recommendProcess.RecommnedProcess;
import userInterface.userAuthentication.AuthProcess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainUI {
    Drink drink;
    BufferedReader br;
    Drink recommendDrink;
    List<Drink> orderList;
    SizeFactory sizeFactory;
    DrinkFactory drinkFactory;
    OptionFactory optionFactory;
    RecommnedProcess recommnedProcess;
    AuthProcess userAuthProcess;
    OrderProcess orderProcess;
    boolean isExited = false;

    public MainUI() {
        orderList = new ArrayList<>();
        sizeFactory = new SizeFactory();
        drinkFactory = new DrinkFactory();
        optionFactory = new OptionFactory();
        br = new BufferedReader(new InputStreamReader(System.in));

        try {
            welcomeUI();
        } catch (ClassCastException e) {
            System.out.println("입력은 1또는 2만 가능합니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private final void welcomeUI() throws IOException, InvalidInputException, SameIdException {
        userAuthProcess = new AuthProcess();

        do {
            System.out.println("=====카페 주문 시스템이 시작됩니다.=====");
            System.out.println("1. 음료 주문 | 2. 이달의 추천 메뉴 보기 | 3. 종료");


            try {
                int menuSelect = Integer.parseInt(br.readLine());

                switch (menuSelect) {
                    case 1:
                        orderProcess();

                        printOrderDetails((ArrayList<Drink>) orderList);
                        break;
                    case 2:
                        showRecommendedMenu();
                        break;
                    case 3:
                        isExited = true;
                        System.out.println("프로그램을 종료합니다.");
                        break;
                    default:
                        throw new InvalidInputException("선택지는 1 또는 2또는 3만 존재합니다.");
                }
            } catch (ClassCastException e) {
                System.out.println("입력은 정수만 가능합니다.");
            }
        } while (!isExited);
    }

    private final void orderProcess() throws IOException, InvalidInputException {
        /**
         * 템플릿 메소드
         */
        orderProcess = new OrderProcess();
        askForAdditionalOrder();
    }

    private final void askForAdditionalOrder() throws IOException {
        System.out.println("===== 다른 음료를 추가로 주문하시겠습니까? =====");
        System.out.println("추가 주문하기 : 1을 입력 | 주문 끝내기 : 2를 입력");

        try {
            int addOrderSelect = Integer.parseInt(br.readLine());

            if (addOrderSelect == 1) {
                drink = orderProcess.getDrink();
                orderList.add(drink);

            } else if (addOrderSelect == 2) {
                drink = orderProcess.getDrink();
                orderList.add(drink);
                isExited = true;
            } else {
                throw new InvalidInputException();
            }
        } catch (ClassCastException | InvalidInputException e) {
            System.out.println("입력은 1과 2만 가능합니다.");
        }
    }

    private final void printOrderDetails(ArrayList<Drink> orderList) {
        Iterator<Drink> iterator = orderList.iterator();

        while (iterator.hasNext()) {
            Drink d = iterator.next();
            System.out.println(d.getDescription() + " $" + d.cost() + ", " + d.getSize());
        }
    }

    private final void showRecommendedMenu() throws InvalidInputException {
        recommnedProcess = new RecommnedProcess();

        recommendDrink = recommnedProcess.getRecommendedDrink();

        System.out.println("오늘의 추천 메뉴는 : " + recommendDrink.getDescription());
    }
}
