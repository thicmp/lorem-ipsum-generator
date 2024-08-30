package br.com.thiagoamm.loremipsum.generator;

import java.util.List;

/**
 * Responsible for defining the contract that specifies
 * the operations that a lorem ipsum text generator must have.
 */
public interface LoremIpsumGenerator {
    List<String> generateWords(int amount);
    List<String> generateWordsBetween(int minAmount, int maxAmount);
    List<String> generateSentences(int amount);
    List<String> generateSentencesBetween(int minAmount, int maxAmount);
    List<String> generateParagraphs(int amount);
    List<String> generateParagraphsBetween(int minAmount, int maxAmount);
}
