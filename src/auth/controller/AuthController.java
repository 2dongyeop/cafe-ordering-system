package auth.controller;

import auth.controller.dto.LogInDto;
import auth.controller.dto.SignUpDto;
import auth.front.AuthUI;
import auth.service.AuthService;
import implementation.enumeration.AuthSelect;
import implementation.applicationException.InvalidInputException;
import implementation.applicationException.SameIdException;
import implementation.singleton.SingletonBufferedReader;

import java.io.IOException;

public class AuthController {
    private SingletonBufferedReader br;
    private boolean logInSuccess = false;
    AuthUI authUI;
    AuthService authService;

    public AuthController() { /* 의존성 주입 : DI */
        authUI = new AuthUI();
        authService = new AuthService();

        br = SingletonBufferedReader.getInstance();
    }

    public void start() {

        try {
            authUI.welcome();
            signUpOrSignIn();
        } catch (IOException e) {}
    }

    private void signUpOrSignIn() throws IOException {

        do {
            authUI.signUpOrSignInUI();

            try {
                switch (AuthSelect.transform(br.readLine())) {
                    case SIGNUP -> signUp();
                    case LOGIN -> logInSuccess = signIn();
                }
            } catch (InvalidInputException e) {
                authUI.invalidInput();
            }
        } while (!logInSuccess);
    }

    private void signUp() throws IOException {
        authUI.signUpUI();

        try {
            authUI.inputId();
            String signUpId = br.readLine();

            authUI.inputPasswd();
            String signUpPassword = br.readLine();

            if (signUpId.equals("") || signUpPassword.equals("")) {
                throw new InvalidInputException();
            }

            SignUpDto signUpDto = new SignUpDto(signUpId, signUpPassword);

            authService.signUp(signUpDto);

        } catch (InvalidInputException e) {
            authUI.invalidInput();
        } catch (SameIdException e) {
            authUI.sameId();
        }
    }

    private boolean signIn() throws IOException {
        authUI.signInUI();

        authUI.inputId();
        String logInId = br.readLine();

        authUI.inputPasswd();
        String logInPassword = br.readLine();

        LogInDto logInDto = new LogInDto(logInId, logInPassword);

        return authService.logIn(logInDto);
    }
}
