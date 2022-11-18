package auth.service;

import auth.controller.dto.LogInDto;
import auth.controller.dto.SignUpDto;
import auth.front.AuthUI;
import auth.repository.UserEntity;
import auth.repository.UserRepository;
import implementation.applicationException.SameIdException;

import java.util.Iterator;
import java.util.List;

public class AuthService {
    AuthUI authUI;
    UserRepository userRepository;

    public AuthService() {
        authUI = new AuthUI();
        userRepository = new UserRepository();
    }

    public void signUp(SignUpDto signUpDto) throws SameIdException {
        List<UserEntity> userList = userRepository.getUserDB();

        String signUpId = signUpDto.getId();
        String signUpPassword = signUpDto.getPassword();

        if (!hasSameIdCheck(signUpId, userList)) {
            userRepository.add(new UserEntity(signUpId, signUpPassword));
            authUI.successSignUp();
        } else {
            throw new SameIdException();
        }
    }

    private boolean hasSameIdCheck(final String id, final List<UserEntity> userList) {
        /**
         * iterator 반복자를 이용한 id 중복 체크
         */
        Iterator<UserEntity> iterator = userList.iterator();
        while (iterator.hasNext()) {
            UserEntity temp = iterator.next();

            if (id.equals(temp.getId()))
                return true;
        }
        return false;
    }

    public boolean logIn(LogInDto logInDto) {
        String logInId = logInDto.getId();
        String logInPassword = logInDto.getPassword();

        Iterator<UserEntity> iterator = userRepository.getUserDB().iterator();
        while (iterator.hasNext()) {
            UserEntity temp = iterator.next();

            if (logInId.equals(temp.getId()) && logInPassword.equals(temp.getPassword())) {
                authUI.successSignIn();

                return true;
            }
        }

        authUI.failSignIn();
        return false;
    }
}
