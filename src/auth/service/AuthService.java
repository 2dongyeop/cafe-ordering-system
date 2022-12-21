package auth.service;

import auth.controller.dto.AuthDto;
import auth.front.AuthUI;
import auth.repository.UserEntity;
import auth.repository.UserRepository;
import auth.service.predicate.AuthPredicate;
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

        if (filterPredicate(signUpId, userList, new FilterSameIdPredicate()))
            throw new SameIdException();

        userRepository.add(new UserEntity(signUpId, signUpPassword));
        authUI.successSignUp();
    }

    private static boolean filterPredicate(
            /**
             * duplicated data에는 id와 password가 들어올 수 있다.
             * 회원가입에서는 id를 data로 넣어 중복 체크에 쓰이고,
             * 로그인 시에는 id와 password를 각각 넣어 일치하는 정보가 있는지 확인하는 용도이다.
             * */
            final String duplicatedData, final List<UserEntity> userList, AuthPredicate p
    ) {
        for (UserEntity user : userList) {

            if (p.test(duplicatedData, user))
                return true;
        }
        return false;
    }

    public boolean signIn(final AuthDto authDto) {
        List<UserEntity> userList = userRepository.getUserDB();

        String logInId = authDto.getId();
        String logInPassword = authDto.getPassword();

        if (filterPredicate(logInId, userList, new FilterSameIdPredicate()) &&
                filterPredicate(logInPassword, userList, new FilterSamePasswordPredicate())) {

            authUI.successSignIn();
            return true;
        }

        authUI.failSignIn();
        return false;
    }

    static class FilterSameIdPredicate implements AuthPredicate {

        @Override
        public boolean test(String id, UserEntity user) {
            return id.equals(user.getId());
        }
    }

    static class FilterSamePasswordPredicate implements AuthPredicate {

        @Override
        public boolean test(String password, UserEntity user) {
            return password.equals(user.getPassword());
        }
    }
}

