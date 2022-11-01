package userInterface.userAuthentication;

import enumeration.AuthSelect;
import enumeration.OrderMethodSelect;
import userInterface.SingletonBufferedReader;
import userInterface.applicationException.InvalidInputException;
import userInterface.applicationException.SameIdException;

import java.io.IOException;
import java.util.*;

public class AuthProcess {
    private boolean logInSuccess = false;
    private static Set<User> userDB;
    private SingletonBufferedReader br;

    public AuthProcess() {
        userDB = new HashSet<>();
        br = SingletonBufferedReader.getInstance();

    }

    public void start() throws IOException, InvalidInputException, SameIdException {
        System.out.println("=====어서오세요. 22세기 빽다방에 오신걸 환영합니다^^.=====");
        System.out.println("=====1. 회원으로 주문하기 | 2. 비회원으로 주문하기");


        try {
            switch (OrderMethodSelect.transform(br.readLine())) {
                case MEMBER_ORDER -> memberOrder();
                case NONMEMBER_SELECT -> nonMemberOrder();
                default -> throw new InvalidInputException("선택지는 1 또는 2만 가능합니다.");
            }
        } catch (ClassCastException e) {
            System.out.println("입력은 정수만 가능합니다.");
        }
    }

    private void memberOrder() throws InvalidInputException, IOException, SameIdException {

        do {
            System.out.println("=====회원 주문 페이지로 이동하기 전, 인증이 필요합니다.=====");
            System.out.println("1. 회원가입 | 2. 로그인");

            try {
                switch (AuthSelect.transform(br.readLine())) {
                    case SIGNUP -> signUp();
                    case LOGIN -> logInSuccess = logIn();
                    default -> throw new InvalidInputException("선택지는 1 또는 2만 가능합니다.");
                }
            } catch (ClassCastException e) {
                System.out.println("입력은 정수만 가능합니다.");
            }
        } while (!logInSuccess);
    }

    private void nonMemberOrder() {
        System.out.println("비회원 주문을 선택하셨습니다.");
    }

    private void signUp() throws IOException, SameIdException, InvalidInputException {
        System.out.println("=====회원가입 페이지입니다.=====");

        System.out.print("id를 입력하세요 > ");
        String signUpId = br.readLine();

        System.out.print("password를 입력하세요 > ");
        String signUpPassword = br.readLine();

        if (signUpId.equals("") || signUpPassword.equals("")) {
            throw new InvalidInputException("공백은 입력할 수 없습니다.");
        }

        if (!hasSameIdCheck(signUpId)) {
            userDB.add(new User(signUpId, signUpPassword));
            System.out.println("회원가입 성공!");
        } else {
            throw new SameIdException("Id 중복 : 동일한 id가 있습니다.");
        }
    }

    private boolean hasSameIdCheck(final String id) {
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

    private boolean logIn() throws IOException {
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
