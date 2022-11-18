package order.front;

import order.repository.drinkEntity.Drink;

public class OrderUI {
    public void welcome() {
        System.out.println("=====카페 주문 시스템이 시작됩니다.=====");
    }

    public void invalidInput() {
        System.out.println("잘못된 입력입니다.");
    }

    public void createDrinkUI() {
        System.out.println("=====음료 주문이 시작됩니다.=====");
        System.out.println("1. 아메리카노 | 2. 카페라떼 | 3. 레몬차 | 4. 아인슈페너");
    }

    public void selectDrinkSizeUI() {
        System.out.println("=====음료 사이즈를 선택하세요.=====");
        System.out.println("1. Small | 2. Medium | 3. Large");
    }

    public void selectOptionsUI() {
        System.out.println("=====추가 옵션을 선택하세요.=====");
        System.out.println("1. Ice | 2. Shot | 3. Syrup | 4. [Do Not add Option]");
    }

    public void askForAdditionalOrderUI() {
        System.out.println("===== 다른 음료를 추가로 주문하시겠습니까? =====");
        System.out.println("추가 주문하기 : 1을 입력 | 주문 끝내기 : 2를 입력");
    }

    public void orderDetailUI() {
        System.out.println("===== 최종 주문 내역 =====");
    }

    public void orderedDrinkUI(Drink drink) {
        System.out.println(drink.getDescription() + " $" + drink.cost() + ", " + drink.getSize());
    }

    public void printTotal(double cost) {
        System.out.println("총 비용은 " + "$" + cost + "입니다.");
    }
}
