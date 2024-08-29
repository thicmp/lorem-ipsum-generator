package br.com.thiagoamm.loremipsum.file;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class LoremIpsumFileReaderTest {

    private static final LoremIpsumFileReader loremIpsumFileReader = new LoremIpsumFileReader();
    private static final String FILE_NAME = "lorem-ipsum.txt";

    // ARRANGE - GIVEN
    //     ACT - WHEN
    //  ASSERT - THEN

    private void printTitle(String text) {
        System.out.println();
        System.out.println("-".repeat(40));
        System.out.println(text);
        System.out.println("-".repeat(40) + "\n");

    }

    @Test
    void testReadLines() {
        List<String> lines = loremIpsumFileReader.readLines(FILE_NAME);
        assertNotNull(lines);
        assertFalse(lines.isEmpty());
    }

    @Test
    void testReadParagraphs() {
        // ARRANGE - GIVEN
        int amount = 1000;

        // ACT - WHEN
        List<String> paragraphs = loremIpsumFileReader.readParagraphs(amount, FILE_NAME);

        // ASSERT - THEN
        assertNotNull(paragraphs); // Parágrafos existem.
        assertFalse(paragraphs.isEmpty()); // Parágrafos não vazios.
        assertEquals(amount, paragraphs.size()); // Parágrafos gerados na quantidade correta.

        printTitle("LOREM IPSUM GENERATED PARAGRAPHS");

        IntStream
                .range(0, paragraphs.size())
                .forEach(i -> System.out.printf("%d - %s%n", i + 1, paragraphs.get(i)));

    }

    @Test
    void testReadSentences() {
        // ARRANGE - GIVEN
        int amount = 100;

        // ACT - WHEN
        List<String> sentences = loremIpsumFileReader.readSentences(amount, FILE_NAME);

        // ASSERT - THEN
        assertNotNull(sentences);
        assertFalse(sentences.isEmpty());
        assertEquals(amount, sentences.size());

        printTitle(" LOREM IPSUM GENERATED SENTENCES");

        IntStream
                .range(0, sentences.size())
                .forEach(i -> System.out.printf("%d - %s%n", i + 1, sentences.get(i)));

    }

    @Test
    void testReadWords() {
        // ARRANGE - GIVEN
        int amount = 500;

        // ACT - WHEN
        List<String> words = loremIpsumFileReader.readWords(amount, FILE_NAME);

        // ASSERT - THEN
        assertNotNull(words);
        assertFalse(words.isEmpty());
        assertEquals(amount, words.size());

        printTitle(" LOREM IPSUM GENERATED WORDS");

        IntStream
                .range(0, words.size())
                .forEach(i -> System.out.printf("%d - %s%n", i + 1, words.get(i)));

    }

}
