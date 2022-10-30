package userInterface;

import drinkFactory.DrinkFactory;
import drinkFactory.OptionFactory;
import drinkFactory.SizeFactory;
import drinkList.Drink;
import userInterface.applicationException.InvalidInputException;
import userInterface.applicationException.SameIdException;
import userInterface.orderProcess.OrderProcess;
import userInterface.recommendProcess.RecommendProcess;
import userInterface.userAuthentication.AuthProcess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


enum CafeSelect {
    ORDERPROCESS,
    SHOWRECOMMENDEDMENU,
    EXIT,
    ADDITIONALORDER;
}

public class MainUI {
    Drink drink;
    BufferedReader br;
    Drink recommendDrink;
    List<Drink> orderList;
    SizeFactory sizeFactory;
    DrinkFactory drinkFactory;
    OptionFactory optionFactory;
    RecommendProcess recommendProcess;
    AuthProcess userAuthProcess;
    OrderProcess orderProcess;
    boolean isExited = false;

    public MainUI() {
        orderList = new ArrayList<>();
        sizeFactory = new SizeFactory();
        drinkFactory = new DrinkFactory();
        optionFactory = new OptionFactory();
        orderProcess = new OrderProcess();
        userAuthProcess = new AuthProcess();
        br = new BufferedReader(new InputStreamReader(System.in));

        try {
            welcomeUI();
        } catch (ClassCastException e) {
            System.out.println("입력은 1또는 2만 가능합니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void welcomeUI() throws IOException, InvalidInputException, SameIdException {
        //음료를 주문하기 전, 먼저 회원/비회원 주문을 선택해야 한다.
        userAuthProcess.start();

        do {
            System.out.println("=====카페 주문 시스템이 시작됩니다.=====");
            System.out.println("1. 음료 주문 | 2. 이달의 추천 메뉴 보기 | 3. 종료");

            try {
                switch (transformCafeOrder(br.readLine())) {
                    case ORDERPROCESS -> orderProcess();
                    case SHOWRECOMMENDEDMENU -> showRecommendedMenu();
                    case EXIT -> {
                        System.out.println("주문 시스템을 종료합니다.");
                        isExited = true;
                    }
                    default -> throw new InvalidInputException("선택지는 1부터 3까지만 가능합니다.");
                }
            } catch (ClassCastException e) {
                System.out.println("입력은 정수만 가능합니다.");
            }
        } while (!isExited);

        System.out.println("===== 최종 주문 내역 =====");
        printOrderDetails(orderList);
    }

    private CafeSelect transformCafeOrder(final String s) throws InvalidInputException {
        CafeSelect cafeSelect = switch (s) {
            case "1" -> {
                yield  CafeSelect.ORDERPROCESS;
            }
            case "2" -> {
                yield CafeSelect.SHOWRECOMMENDEDMENU;
            }
            case "3" -> {
                yield CafeSelect.EXIT;
            }
            default -> throw new InvalidInputException("1부터 3까지만 입력 가능합니다.");
        };
        return cafeSelect;
    }

    private void orderProcess() throws IOException, InvalidInputException {
        orderProcess.start();
        askForAdditionalOrder();
    }

    private void askForAdditionalOrder() throws IOException {
        System.out.println("===== 다른 음료를 추가로 주문하시겠습니까? =====");
        System.out.println("추가 주문하기 : 1을 입력 | 주문 끝내기 : 2를 입력");

        try {
            switch (transformAdditionalOrder(br.readLine())) {
                case ADDITIONALORDER -> {
                    drink = orderProcess.getDrink();
                    orderList.add(drink);}
                case EXIT -> {
                    drink = orderProcess.getDrink();
                    orderList.add(drink);
                    isExited = true;}
                default -> throw new InvalidInputException();
            }
        } catch (ClassCastException | InvalidInputException e) {
            System.out.println("입력은 1과 2만 가능합니다.");
        }
    }

    private CafeSelect transformAdditionalOrder(final String s) throws InvalidInputException {
        CafeSelect orderSelect = switch (s) {
            case "1" -> {
                yield  CafeSelect.ADDITIONALORDER;
            }
            case "2" -> {
                yield CafeSelect.EXIT;
            }
            default -> throw new InvalidInputException("1부터 2까지만 입력 가능합니다.");
        };
        return orderSelect;
    }

    private void printOrderDetails(final List orderList) {
        Iterator<Drink> iterator = orderList.iterator();

        while (iterator.hasNext()) {
            Drink d = iterator.next();
            System.out.println(d.getDescription() + " $" + d.cost() + ", " + d.getSize());
        }
    }

    private void showRecommendedMenu() throws InvalidInputException {
        recommendProcess = new RecommendProcess();

        recommendDrink = recommendProcess.getRecommendedDrink();

        System.out.println("오늘의 추천 메뉴는 : " + recommendDrink.getDescription());
    }
}
