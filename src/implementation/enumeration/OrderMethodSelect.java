package implementation.enumeration;

import implementation.applicationException.InvalidInputException;

public enum OrderMethodSelect {
    MEMBER_ORDER,
    NONMEMBER_SELECT;

    public static OrderMethodSelect transform(final String s) throws InvalidInputException {
        OrderMethodSelect authSelect = switch (s) {
            case "1" -> {
                yield  MEMBER_ORDER;
            }
            case "2" -> {
                yield NONMEMBER_SELECT;
            }
            default -> throw new InvalidInputException("1또는 2만 입력 가능합니다.");
        };
        return authSelect;
    }
}
