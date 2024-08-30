package br.com.thiagoamm.loremipsum.generator;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoremIpsumTextGeneratorTest {

    private final LoremIpsumGenerator loremIpsumGenerator = new LoremIpsumTextGenerator();

    @Test
    void testWordGeneration() {
        // GIVEN (ARRANGE) - Given a test scenario.
        final int expectedWordsAmount = 10;
        // WHEN (ACT) - When the action occurs.
        List<String> generatedWords = loremIpsumGenerator.generateWords(expectedWordsAmount);
        // THEN (ASSERT) - Check if the obtained value is equal to the expected value.
        final int obtainedWordsAmount = generatedWords.size();
        assertEquals(expectedWordsAmount, obtainedWordsAmount);
    }

    @Test
    void testWordGenerationBetween() {
        // GIVEN
        final int minWordsAmount = 3;
        final int maxWordsAmount = 6;
        final Predicate<List<String>> expectedWordsAmountCondition = l ->
                l.size() >= minWordsAmount && l.size() <= maxWordsAmount;
        // WHEN
        List<String> generatedWords = loremIpsumGenerator.generateWordsBetween(minWordsAmount, maxWordsAmount);
        // THEN
        assertTrue(expectedWordsAmountCondition.test(generatedWords));
    }

    @Test
    void testSentenceGeneration() {
        // GIVEN
        final int expectedSentencesAmount = 250;
        // WHEN
        List<String> generatedSentences = loremIpsumGenerator.generateSentences(expectedSentencesAmount);
        // THEN
        final int obtainedSentencesAmount = generatedSentences.size();
        assertEquals(expectedSentencesAmount, obtainedSentencesAmount);
    }

    @Test
    void testSentenceGenerationBetween() {
        // GIVEN
        final int minSentencesAmount = 250;
        final int maxSentencesAmount = 500;
        final Predicate<List<String>> expectedWordsAmountCondition = l ->
                l.size() >= minSentencesAmount && l.size() <= maxSentencesAmount;
        // WHEN
        List<String> generatedSentences = loremIpsumGenerator
                .generateSentencesBetween(minSentencesAmount, maxSentencesAmount);
        // THEN
        assertTrue(expectedWordsAmountCondition.test(generatedSentences));
    }

    @Test
    void testParagraphGeneration() {
        // GIVEN
        final int expectedParagraphsAmount = 150;
        // WHEN
        List<String> generatedParagraphs = loremIpsumGenerator.generateParagraphs(expectedParagraphsAmount);
        // THEN
        final int obtainedParagraphsAmount = generatedParagraphs.size();
        assertEquals(expectedParagraphsAmount, obtainedParagraphsAmount);
    }

    @Test
    void testParagraphGenerationBetween() {
        // GIVEN
        final int minParagraphsAmount = 250;
        final int maxParagraphsAmount = 1000;
        Predicate<List<String>> expectedParagraphsAmountCondition = l ->
                l.size() >= minParagraphsAmount && l.size() <= maxParagraphsAmount;
        // WHEN
        List<String> generatedParagraphs = loremIpsumGenerator
                .generateParagraphsBetween(minParagraphsAmount, maxParagraphsAmount);
        // THEN
        assertTrue(expectedParagraphsAmountCondition.test(generatedParagraphs));
    }

}
