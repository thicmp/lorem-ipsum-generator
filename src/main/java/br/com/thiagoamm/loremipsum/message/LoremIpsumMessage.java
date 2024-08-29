package br.com.thiagoamm.loremipsum.message;

import br.com.thiagoamm.loremipsum.enumeration.TextualEntity;

/**
 * Responsible for storing the interaction messages presented to the user.
 */
public final class LoremIpsumMessage {

    private static final String AMOUNT_CANNOT_BE_LOWER_THAN = "Amount of %s cannot be lower than %d!";
    private static final String AMOUNT_CANNOT_BE_GREATER_THAN = "Amount of %s cannot be greater than %d!";
    public static final String FILE_NAME_IS_NULL = "File name is null!";
    public static final String FILE_NAME_IS_BLANK = "File name is blank!";

    private LoremIpsumMessage() {
        throw new UnsupportedOperationException();
    }

    public static String messageAmountCannotBeLowerThanLimit(TextualEntity target, int limit) {
        return String.format(AMOUNT_CANNOT_BE_LOWER_THAN, target.getPlural().toLowerCase(), limit);
    }

    public static String messageAmountCannotBeGreaterThanLimit(TextualEntity target, int limit) {
        return String.format(AMOUNT_CANNOT_BE_GREATER_THAN, target.getPlural().toLowerCase(), limit);
    }

}
