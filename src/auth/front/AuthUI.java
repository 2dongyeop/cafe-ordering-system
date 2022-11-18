package auth.front;

public class AuthUI {
    public void welcome() {
        System.out.println("=====어서오세요. 22세기 빽다방에 오신걸 환영합니다^^.=====");
    }

    public void invalidInput() {
        System.out.println("잘못된 선택지입니다.");
    }

    public void sameId() {
        System.out.println("Id 중복 : 동일한 id가 있습니다.");
    }

    public void signUpOrSignInUI() {
        System.out.println("1. 회원가입 | 2. 로그인");
    }

    public void signUpUI() {
        System.out.println("=====회원가입 페이지입니다.=====");
    }

    public void inputId() {
        System.out.print("id를 입력하세요 > ");
    }

    public void inputPasswd() {
        System.out.print("password를 입력하세요 > ");
    }

    public void successSignUp() {
        System.out.println("회원가입 성공!");
    }

    public void signInUI() {
        System.out.println("=====로그인 페이지입니다.=====");
    }

    public void successSignIn() {
        System.out.println("로그인 성공!");
    }

    public void failSignIn() {
        System.out.println("로그인 실패!");
    }
}
