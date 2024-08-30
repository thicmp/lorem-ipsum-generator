package br.com.thiagoamm.loremipsum.generator;

import br.com.thiagoamm.loremipsum.file.LoremIpsumFileReader;

import java.util.Collections;
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
    public List<String> generateShuffleWords(int amount) {
        List<String> words = fileReader.readWords(amount, FILE_NAME);
        Collections.shuffle(words);
        return words;
    }

    @Override
    public List<String> generateShuffleWordsBetween(int minAmount, int maxAmount) {
        int amount = getRandomAmount(minAmount, maxAmount);
        List<String> words = fileReader.readWords(amount, FILE_NAME);
        Collections.shuffle(words);
        return words;
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
    public List<String> generateShuffleSentences(int amount) {
        List<String> sentences = fileReader.readSentences(amount, FILE_NAME);
        Collections.shuffle(sentences);
        return sentences;
    }

    @Override
    public List<String> generateShuffleSentencesBetween(int minAmount, int maxAmount) {
        int amount = getRandomAmount(minAmount, maxAmount);
        List<String> sentences = fileReader.readSentences(amount, FILE_NAME);
        Collections.shuffle(sentences);
        return sentences;
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

    @Override
    public List<String> generateShuffleParagraphs(int amount) {
        List<String> paragraphs = fileReader.readParagraphs(amount, FILE_NAME);
        Collections.shuffle(paragraphs);
        return paragraphs;
    }

    @Override
    public List<String> generateShuffleParagraphsBetween(int minAmount, int maxAmount) {
        int amount = getRandomAmount(minAmount, maxAmount);
        List<String> paragraphs = fileReader.readParagraphs(amount, FILE_NAME);
        Collections.shuffle(paragraphs);
        return paragraphs;
    }

    private int getRandomAmount(int minAmount, int maxAmount) {
        return minAmount + random.nextInt(maxAmount - minAmount + 1);
    }
}
