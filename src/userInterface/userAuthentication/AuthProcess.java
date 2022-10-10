package userInterface.userAuthentication;

import userInterface.applicationException.InvalidInputException;
import userInterface.applicationException.SameIdException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AuthProcess {
    private boolean logInSuccess = false;
    private static Set<User> userDB;
    private BufferedReader br;

    public AuthProcess() throws IOException, InvalidInputException, SameIdException {
        userDB = new HashSet<>();
        br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("=====어서오세요. 22세기 빽다방에 오신걸 환영합니다^^.=====");
        System.out.println("=====1. 회원으로 주문하기 | 2. 비회원으로 주문하기");

        try {
            int inputOrderMethod = Integer.parseInt(br.readLine());

            switch (inputOrderMethod) {
                case 1:
                    memberOrder();
                    break;
                case 2:
                    nonMemberOrder();
                    break;
                default:
                    throw new InvalidInputException("선택지는 1 또는 2만 가능합니다.");
            }
        } catch (ClassCastException e) {
            System.out.println("입력은 정수만 가능합니다.");
        }
    }

    private final void memberOrder() throws InvalidInputException, IOException, SameIdException {

        do {
            System.out.println("=====회원 주문 페이지로 이동하기 전, 인증이 필요합니다.=====");
            System.out.println("1. 회원가입 | 2. 로그인");

            try {
                int inputAuthMethod = Integer.parseInt(br.readLine());

                switch (inputAuthMethod) {
                    case 1:
                        signUp();
                        break;
                    case 2:
                        logInSuccess = logIn();
                        break;
                    default:
                        throw new InvalidInputException("선택지는 1 또는 2만 가능합니다.");
                }
            } catch (ClassCastException e) {
                System.out.println("입력은 정수만 가능합니다.");
            }
        } while (!logInSuccess);
    }

    private final void nonMemberOrder() {
        System.out.println("비회원 주문을 선택하셨습니다.");
    }

    private final void signUp() throws IOException, SameIdException {
        System.out.println("=====회원가입 페이지입니다.=====");

        System.out.print("id를 입력하세요 > ");
        String signUpId = br.readLine();

        System.out.print("password를 입력하세요 > ");
        String signUpPassword = br.readLine();

        if (!hasSameIdCheck(signUpId)) {
            userDB.add(new User(signUpId, signUpPassword));
            System.out.println("회원가입 성공!");
        } else {
            System.out.println("Id 중복 : 동일한 id가 있습니다.");
            return;
        }
    }

    private final boolean hasSameIdCheck(final String id) {
        /**
         * iterator 반복자를 이용한 id 중복 체크
         */
        Iterator<User> iterator = userDB.iterator();
        while (iterator.hasNext()) {
            User temp = iterator.next();

            if (id.equals(temp.getId()))
                return true;
        }
        return false;
    }

    private final boolean logIn() throws IOException {
        System.out.println("=====로그인 페이지입니다.=====");

        System.out.print("id를 입력하세요 > ");
        String logInId = br.readLine();

        System.out.print("password를 입력하세요 > ");
        String logInPassword = br.readLine();

        Iterator<User> iterator = userDB.iterator();
        while (iterator.hasNext()) {
            User temp = iterator.next();

            if (logInId.equals(temp.getId()) && logInPassword.equals(temp.getPassword())) {
                System.out.println("로그인 성공");
                return true;
            }
        }

        System.out.println("로그인 실패");
        return false;
    }
}
