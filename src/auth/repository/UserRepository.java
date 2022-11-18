package auth.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserRepository {
    private Set<UserEntity> userDB;

    public UserRepository() {
        userDB  = new HashSet<>();
    }

    public List<UserEntity> getUserDB() {
        return userDB.stream().toList();
    }

    public void add(UserEntity userEntity) {
        userDB.add(userEntity);
    }
}
