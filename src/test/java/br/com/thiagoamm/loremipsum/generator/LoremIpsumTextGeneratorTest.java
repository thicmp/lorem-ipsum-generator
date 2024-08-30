package br.com.thiagoamm.loremipsum.generator;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class LoremIpsumTextGeneratorTest {

    private final LoremIpsumGenerator loremIpsumGenerator = new LoremIpsumTextGenerator();

    @Test
    void testWordsGeneration() {
        // GIVEN (ARRANGE) - Given a test scenario.
        final int expectedWordsAmount = 10;
        // WHEN (ACT) - When the action occurs.
        List<String> words = loremIpsumGenerator.generateWords(expectedWordsAmount);
        // THEN (ASSERT) - Check if the obtained value is equal to the expected value.
        final int generatedWordsAmount = words.size();
        assertEquals(expectedWordsAmount, generatedWordsAmount);
    }

    @Test
    void testWordsGenerationBetween() {
        // GIVEN
        final int minWordsAmount = 3;
        final int maxWordsAmount = 6;
        final Predicate<List<String>> expectedWordsAmountCondition =
                l -> l.size() >= minWordsAmount && l.size() <= maxWordsAmount;
        // WHEN
        List<String> words = loremIpsumGenerator.generateWordsBetween(minWordsAmount, maxWordsAmount);
        // THEN
        assertTrue(expectedWordsAmountCondition.test(words));
    }

    @Test
    void testShuffleWordsGeneration() {
        // GIVEN
        final int expectedWordsAmount = 10;
        // WHEN
        List<String> words = loremIpsumGenerator.generateWords(expectedWordsAmount);
        List<String> shuffledWords = loremIpsumGenerator.generateShuffleWords(expectedWordsAmount);
        // THEN
        final int generatedWordsAmount = words.size();
        assertEquals(expectedWordsAmount, generatedWordsAmount);
        assertEquals(words.size(), shuffledWords.size());
        assertNotEquals(words.get(0), shuffledWords.get(0));
    }

    @Test
    void testShuffleWordsGenerationBetween() {
        // GIVEN
        final int minWordsAmount = 3;
        final int maxWordsAmount = 6;
        final Predicate<List<String>> expectedWordsAmountCondition = l ->
                l.size() >= minWordsAmount && l.size() <= maxWordsAmount;
        // WHEN
        List<String> words = loremIpsumGenerator.generateShuffleWordsBetween(minWordsAmount, maxWordsAmount);
        // THEN
        assertNotNull(words);
        assertTrue(expectedWordsAmountCondition.test(words));
    }

    @Test
    void testSentencesGeneration() {
        // GIVEN
        final int expectedSentencesAmount = 250;
        // WHEN
        List<String> sentences = loremIpsumGenerator.generateSentences(expectedSentencesAmount);
        // THEN
        final int generatedSentencesAmount = sentences.size();
        assertEquals(expectedSentencesAmount, generatedSentencesAmount);
    }

    @Test
    void testSentencesGenerationBetween() {
        // GIVEN
        final int minSentencesAmount = 250;
        final int maxSentencesAmount = 500;
        final Predicate<List<String>> expectedWordsAmountCondition =
                l -> l.size() >= minSentencesAmount && l.size() <= maxSentencesAmount;
        // WHEN
        List<String> sentences = loremIpsumGenerator
                .generateSentencesBetween(minSentencesAmount, maxSentencesAmount);
        // THEN
        assertTrue(expectedWordsAmountCondition.test(sentences));
    }

    @Test
    void testShuffleSentencesGeneration() {
        // GIVEN
        final int expectedSentencesAmount = 10;
        // WHEN
        List<String> sentences = loremIpsumGenerator.generateSentences(expectedSentencesAmount);
        List<String> shuffledSentences = loremIpsumGenerator.generateShuffleSentences(expectedSentencesAmount);
        // THEN
        final int generatedSentencesAmount = sentences.size();
        assertEquals(expectedSentencesAmount, generatedSentencesAmount);
        assertEquals(sentences.size(), shuffledSentences.size());
        assertNotEquals(sentences.get(0), shuffledSentences.get(0));
    }

    @Test
    void testShuffleSentencesGenerationBetween() {
        // GIVEN
        final int minSentencesAmount = 3;
        final int maxSentencesAmount = 6;
        final Predicate<List<String>> expectedSentencesAmountCondition =
                l -> l.size() >= minSentencesAmount && l.size() <= maxSentencesAmount;
        // WHEN
        List<String> sentences = loremIpsumGenerator
                .generateShuffleSentencesBetween(minSentencesAmount, maxSentencesAmount);
        // THEN
        assertNotNull(sentences);
        assertTrue(expectedSentencesAmountCondition.test(sentences));
    }

    @Test
    void testParagraphsGeneration() {
        // GIVEN
        final int expectedParagraphsAmount = 150;
        // WHEN
        List<String> paragraphs = loremIpsumGenerator.generateParagraphs(expectedParagraphsAmount);
        // THEN
        final int generatedParagraphsAmount = paragraphs.size();
        assertEquals(expectedParagraphsAmount, generatedParagraphsAmount);
    }

    @Test
    void testParagraphsGenerationBetween() {
        // GIVEN
        final int minParagraphsAmount = 250;
        final int maxParagraphsAmount = 1000;
        Predicate<List<String>> expectedParagraphsAmountCondition = l ->
                l.size() >= minParagraphsAmount && l.size() <= maxParagraphsAmount;
        // WHEN
        List<String> paragraphs = loremIpsumGenerator
                .generateParagraphsBetween(minParagraphsAmount, maxParagraphsAmount);
        // THEN
        assertTrue(expectedParagraphsAmountCondition.test(paragraphs));
    }

    @Test
    void testShuffleParagraphsGeneration() {
        // GIVEN
        final int expectedParagraphsAmount = 10;
        // WHEN
        List<String> paragraphs = loremIpsumGenerator.generateParagraphs(expectedParagraphsAmount);
        List<String> shuffledParagraphs = loremIpsumGenerator.generateShuffleParagraphs(expectedParagraphsAmount);
        // THEN
        final int generatedParagraphsAmount = paragraphs.size();
        assertEquals(expectedParagraphsAmount, generatedParagraphsAmount);
        assertEquals(paragraphs.size(), shuffledParagraphs.size());
        assertNotEquals(paragraphs.get(0), shuffledParagraphs.get(0));
    }

    @Test
    void testShuffleParagraphsGenerationBetween() {
        // GIVEN
        final int minParagraphsAmount = 3;
        final int maxParagraphsAmount = 6;
        final Predicate<List<String>> expectedParagraphsAmountCondition =
                l -> l.size() >= minParagraphsAmount && l.size() <= maxParagraphsAmount;
        // WHEN
        List<String> paragraphs = loremIpsumGenerator
                .generateShuffleParagraphsBetween(minParagraphsAmount, maxParagraphsAmount);
        // THEN
        assertNotNull(paragraphs);
        assertTrue(expectedParagraphsAmountCondition.test(paragraphs));
    }


}
