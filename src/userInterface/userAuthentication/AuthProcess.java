package userInterface.userAuthentication;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AuthProcess {
    BufferedReader br;

    public AuthProcess() {
        br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("=====어서오세요. 22세기 빽다방에 오신걸 환영합니다^^.=====");
        System.out.println("=====1. 회원으로 주문하기 | 2. 비회원으로 주문하기 | 3. 종료=====");


    }
}
