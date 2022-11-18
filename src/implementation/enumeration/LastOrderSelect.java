package implementation.enumeration;

import implementation.applicationException.InvalidInputException;

public enum LastOrderSelect {
    EXIT,
    ADDITIONAL_ORDER;

    public static LastOrderSelect transform(final String s) throws InvalidInputException {
        LastOrderSelect orderSelect = switch (s) {
            case "1" -> {
                yield ADDITIONAL_ORDER;
            }
            case "2" -> {
                yield EXIT;
            }
            default -> throw new InvalidInputException("1부터 2까지만 입력 가능합니다.");
        };
        return orderSelect;
    }
}
