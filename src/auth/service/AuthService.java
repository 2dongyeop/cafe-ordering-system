package auth.service;

import auth.controller.dto.AuthDto;
import auth.front.AuthUI;
import auth.repository.UserEntity;
import auth.repository.UserRepository;
import implementation.applicationException.SameIdException;

import java.util.Iterator;
import java.util.List;

public class AuthService {
    private final AuthUI authUI;
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        authUI = new AuthUI();
        this.userRepository = userRepository;
    }

    public void signUp(final AuthDto authDto) throws SameIdException {
        List<UserEntity> userList = userRepository.getUserDB();

        String signUpId = authDto.getId();
        String signUpPassword = authDto.getPassword();

        if (hasSameIdCheck(signUpId, userList))
            throw new SameIdException();

        userRepository.add(new UserEntity(signUpId, signUpPassword));
        authUI.successSignUp();
    }

    private static boolean hasSameIdCheck(final String id, final List<UserEntity> userList) {
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

    public boolean signIn(final AuthDto authDto) {
        String logInId = authDto.getId();
        String logInPassword = authDto.getPassword();

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

