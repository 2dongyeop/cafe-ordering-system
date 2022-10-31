package enumeration;

import userInterface.applicationException.InvalidInputException;

public enum OrderMethodSelect {
    MEMBERORDER,
    NONMEMBERSELECT;

    public static OrderMethodSelect transform(final String s) throws InvalidInputException {
        OrderMethodSelect authSelect = switch (s) {
            case "1" -> {
                yield  MEMBERORDER;
            }
            case "2" -> {
                yield NONMEMBERSELECT;
            }
            default -> throw new InvalidInputException("1또는 2만 입력 가능합니다.");
        };
        return authSelect;
    }
}
