package br.com.thiagoamm.loremipsum.generator;

import br.com.thiagoamm.loremipsum.file.LoremIpsumFileReader;

import java.util.List;
import java.util.Random;

/**
 * Responsible to generate Lorem Ipsum texts randomly.
 */
public class LoremIpsumTextGenerator implements LoremIpsumGenerator {

    private final LoremIpsumFileReader fileReader;
    private final Random random;
    private static final String FILE_NAME = "lorem-ipsum.txt";

    public LoremIpsumTextGenerator() {
        this.random = new Random();
        this.fileReader = new LoremIpsumFileReader();
    }

    @Override
    public List<String> generateWords(int amount) {
        return fileReader.readWords(amount, FILE_NAME);
    }

    @Override
    public List<String> generateWordsBetween(int minAmount, int maxAmount) {
        int amount = getRandomAmount(minAmount, maxAmount);
        return fileReader.readWords(amount, FILE_NAME);
    }

    @Override
    public List<String> generateSentences(int amount) {
        return fileReader.readSentences(amount, FILE_NAME);
    }

    @Override
    public List<String> generateSentencesBetween(int minAmount, int maxAmount) {
        int amount = getRandomAmount(minAmount, maxAmount);
        return fileReader.readSentences(amount, FILE_NAME);
    }

    @Override
    public List<String> generateParagraphs(int amount) {
        return fileReader.readParagraphs(amount, FILE_NAME);
    }

    @Override
    public List<String> generateParagraphsBetween(int minAmount, int maxAmount) {
        int amount = getRandomAmount(minAmount, maxAmount);
        return fileReader.readParagraphs(amount, FILE_NAME);
    }

    private int getRandomAmount(int minAmount, int maxAmount) {
        return minAmount + random.nextInt(maxAmount - minAmount + 1);
    }
}
