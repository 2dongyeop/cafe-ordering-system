package enumeration;

import userInterface.applicationException.InvalidInputException;

public enum MenuSelect {
    ORDERPROCESS,
    SHOWRECOMMENDEDMENU,
    EXIT;

    public static MenuSelect transform(final String s) throws InvalidInputException {
        MenuSelect menuSelect = switch (s) {
            case "1" -> {
                yield  ORDERPROCESS;
            }
            case "2" -> {
                yield SHOWRECOMMENDEDMENU;
            }
            case "3" -> {
                yield EXIT;
            }
            default -> throw new InvalidInputException("1부터 3까지만 입력 가능합니다.");
        };
        return menuSelect;
    }
}