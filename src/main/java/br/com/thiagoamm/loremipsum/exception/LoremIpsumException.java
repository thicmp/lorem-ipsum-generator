package br.com.thiagoamm.loremipsum.exception;

import br.com.thiagoamm.loremipsum.enumeration.TextualEntity;
import br.com.thiagoamm.loremipsum.message.LoremIpsumMessage;

import static br.com.thiagoamm.loremipsum.message.LoremIpsumMessage.messageAmountCannotBeGreaterThanLimit;
import static br.com.thiagoamm.loremipsum.message.LoremIpsumMessage.messageAmountCannotBeLowerThanLimit;

public class LoremIpsumException extends RuntimeException {

    public LoremIpsumException() {
        super();
    }

    public LoremIpsumException(String message) {
        super(message);
    }

    public LoremIpsumException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoremIpsumException(Throwable cause) {
        super(cause);
    }

    public LoremIpsumException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public static LoremIpsumException ofAmountCannotBeLowerThanLimitException(TextualEntity target, int limit) {
        return new LoremIpsumException(messageAmountCannotBeLowerThanLimit(target, limit));
    }

    public static LoremIpsumException ofAmountCannotBeGreaterThanLimitException(TextualEntity target, int limit) {
        return new LoremIpsumException(messageAmountCannotBeGreaterThanLimit(target, limit));
    }

    public static LoremIpsumException ofFileNameIsNullException() {
        return new LoremIpsumException(LoremIpsumMessage.FILE_NAME_IS_NULL);
    }

    public static LoremIpsumException ofFileNameIsBlankException() {
        return new LoremIpsumException(LoremIpsumMessage.FILE_NAME_IS_BLANK);
    }

    public static void amountCannotBeLowerThanLimitException(TextualEntity target, int limit) {
        throw ofAmountCannotBeLowerThanLimitException(target, limit);
    }

    public static void amountCannotBeGreaterThanLimitException(TextualEntity target, int limit) {
        throw ofAmountCannotBeGreaterThanLimitException(target, limit);
    }

    public static void fileNameIsNullException() {
        throw ofFileNameIsNullException();
    }

    public static void fileNameIsBlankException() {
        throw ofFileNameIsBlankException();
    }

}
