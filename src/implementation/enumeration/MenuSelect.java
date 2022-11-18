package implementation.enumeration;

import implementation.applicationException.InvalidInputException;

public enum MenuSelect {
    ORDER_PROCESS,
    SHOW_RECOMMENDED_MENU,
    EXIT;

    public static MenuSelect transform(final String s) throws InvalidInputException {
        MenuSelect menuSelect = switch (s) {
            case "1" -> {
                yield  ORDER_PROCESS;
            }
            case "2" -> {
                yield SHOW_RECOMMENDED_MENU;
            }
            case "3" -> {
                yield EXIT;
            }
            default -> throw new InvalidInputException("1부터 3까지만 입력 가능합니다.");
        };
        return menuSelect;
    }
}