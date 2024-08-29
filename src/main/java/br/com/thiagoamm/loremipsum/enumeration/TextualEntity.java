package br.com.thiagoamm.loremipsum.enumeration;

/**
 * Responsible for representing a textual entity such as
 * a word, sentence or paragraph.
 */
public enum TextualEntity {

    WORD("Word", "Words"),
    SENTENCE("Sentence", "Sentences"),
    PARAGRAPH("Paragraph", "Paragraphs");

    private final String singular;
    private final String plural;

    TextualEntity(String singular, String plural) {
        this.singular = singular;
        this.plural = plural;
    }

    public String getSingular() {
        return singular;
    }

    public String getPlural() {
        return plural;
    }
    
}
