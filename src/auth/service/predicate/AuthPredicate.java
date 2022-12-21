package auth.service.predicate;

import auth.repository.UserEntity;

public interface AuthPredicate {
    boolean test (String id, UserEntity userEntity);
}

