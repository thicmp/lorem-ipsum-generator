package br.com.thiagoamm.loremipsum.enumeration;

/**
 * Responsible for specifying quantity limits for each textual entity.
 */
public enum TextualEntityAmountLimit {

    WORD_LOWER_LIMIT(0),
    WORD_UPPER_LIMIT(100_000),
    SENTENCE_LOWER_LIMIT(0),
    SENTENCE_UPPER_LIMIT(10_000),
    PARAGRAPH_LOWER_LIMIT(0),
    PARAGRAPH_UPPER_LIMIT(1000);

    private final int value;

    TextualEntityAmountLimit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static int getLowerLimit(TextualEntity textualEntity) {
        if (TextualEntity.WORD.equals(textualEntity)) {
            return WORD_LOWER_LIMIT.getValue();
        }
        if (TextualEntity.SENTENCE.equals(textualEntity)) {
            return SENTENCE_LOWER_LIMIT.getValue();
        }
        if (TextualEntity.PARAGRAPH.equals(textualEntity)) {
            return PARAGRAPH_LOWER_LIMIT.getValue();
        }
        return 0;
    }

    public static int getUpperLimit(TextualEntity textualEntity) {
        if (TextualEntity.WORD.equals(textualEntity)) {
            return WORD_UPPER_LIMIT.getValue();
        }
        if (TextualEntity.SENTENCE.equals(textualEntity)) {
            return SENTENCE_UPPER_LIMIT.getValue();
        }
        if (TextualEntity.PARAGRAPH.equals(textualEntity)) {
            return PARAGRAPH_UPPER_LIMIT.getValue();
        }
        return 1;
    }

}
