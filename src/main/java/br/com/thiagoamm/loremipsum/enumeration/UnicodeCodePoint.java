package br.com.thiagoamm.loremipsum.enumeration;

/**
 * Unicode code of the control characters used
 * to divide the text into paragraphs, sentences or words.
 */
public enum UnicodeCodePoint {

    END_OF_LINE(-1),
    LINE_FEED(10),
    DOT(46),
    SPACE(32),
    COMMA(44);

    private final int value;

    UnicodeCodePoint(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
