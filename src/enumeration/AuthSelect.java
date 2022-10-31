package enumeration;

import userInterface.applicationException.InvalidInputException;

public enum AuthSelect {
    SIGNUP,
    LOGIN;

    public static AuthSelect transform(final String s) throws InvalidInputException {
        AuthSelect authSelect = switch (s) {
            case "1" -> {
                yield SIGNUP;
            }
            case "2" -> {
                yield LOGIN;
            }
            default -> throw new InvalidInputException("1또는 2만 입력 가능합니다.");
        };
        return authSelect;
    }
}
