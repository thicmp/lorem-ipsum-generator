package br.com.thiagoamm.loremipsum.file;

import br.com.thiagoamm.loremipsum.enumeration.TextualEntity;
import br.com.thiagoamm.loremipsum.enumeration.TextualEntityAmountLimit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import static br.com.thiagoamm.loremipsum.enumeration.TextualEntity.PARAGRAPH;
import static br.com.thiagoamm.loremipsum.enumeration.UnicodeCodePoint.*;
import static br.com.thiagoamm.loremipsum.exception.LoremIpsumException.amountCannotBeGreaterThanLimitException;
import static br.com.thiagoamm.loremipsum.exception.LoremIpsumException.amountCannotBeLowerThanLimitException;
import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Responsável por ler as linhas do arquivo que contém o texto lorem ipsum.
 */
public final class LoremIpsumFileReader {

    private static final Logger logger = Logger.getLogger(LoremIpsumFileReader.class.getName());

    public List<String> readLines(String fileName) {
        List<String> lines = new LinkedList<>();
        try (BufferedReader fileReader = getBufferedReader(fileName, getClass())) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            logger.warning(e.getMessage());
        }
        return lines;
    }

    public List<String> readParagraphs(int amount, String fileName) {
        checkAmountOf(PARAGRAPH, amount);
        List<String> paragraphs = new LinkedList<>();
        try (BufferedReader fileReader = getBufferedReader(fileName, getClass())) {
            int unicodeCodePoint;
            String character;
            StringBuilder paragraph = new StringBuilder();
            int readedParagraphs = 0;
            while ((unicodeCodePoint = fileReader.read()) != END_OF_LINE.getValue()) {
                if (unicodeCodePoint != LINE_FEED.getValue()) {
                    character = Character.toString(unicodeCodePoint);
                    paragraph.append(character);
                } else {
                    if (!paragraph.isEmpty()) {
                        paragraphs.add(paragraph.toString().trim());
                        paragraph.setLength(0);
                        readedParagraphs++;
                        if (readedParagraphs == amount) {
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            logger.warning(e.getMessage());
        }
        return paragraphs;
    }

    public List<String> readSentences(int amount, String fileName) {
        checkAmountOf(TextualEntity.SENTENCE, amount);
        List<String> sentences = new LinkedList<>();
        try (BufferedReader fileReader = getBufferedReader(fileName, getClass())) {
            int unicodeCodePoint;
            String character;
            StringBuilder sentence = new StringBuilder();
            int readedSentences = 0;
            while ((unicodeCodePoint = fileReader.read()) != END_OF_LINE.getValue()) {
                if (unicodeCodePoint != LINE_FEED.getValue() && unicodeCodePoint != DOT.getValue()) {
                    character = Character.toString(unicodeCodePoint);
                    sentence.append(character);
                } else {
                    if (!sentence.isEmpty()) {
                        sentence.append(".");
                        sentences.add(sentence.toString().trim());
                        sentence.setLength(0);
                        readedSentences++;
                        if (readedSentences == amount) {
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            logger.warning(e.getMessage());
        }
        return sentences;
    }

    public List<String> readWords(int amount, String fileName) {
        checkAmountOf(TextualEntity.WORD, amount);
        List<String> words = new LinkedList<>();
        try (BufferedReader fileReader = getBufferedReader(fileName, getClass())) {
            int unicodeCodePoint;
            String character;
            StringBuilder word = new StringBuilder();
            int readedWords = 0;
            while ((unicodeCodePoint = fileReader.read()) != END_OF_LINE.getValue()) {
                if (unicodeCodePoint != LINE_FEED.getValue()
                        && unicodeCodePoint != SPACE.getValue()
                        && unicodeCodePoint != COMMA.getValue()
                        && unicodeCodePoint != DOT.getValue()) {
                    character = Character.toString(unicodeCodePoint);
                    word.append(character);
                } else {
                    if (!word.isEmpty()) {
                        words.add(word.toString().trim());
                        word.setLength(0);
                        readedWords++;
                        if (readedWords == amount) {
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            logger.warning(e.getMessage());
        }
        return words;
    }

    private static void checkAmountOf(TextualEntity target, int amount) {
        try {
            checkLowerLimit(target, amount, TextualEntityAmountLimit.getLowerLimit(target));
            checkUpperLimit(target, amount, TextualEntityAmountLimit.getUpperLimit(target));
        } catch (RuntimeException e) {
            logger.warning(e.getMessage());
        }
    }

    private static void checkLowerLimit(TextualEntity target, int amount, int lowerLimit) {
        if (amount < lowerLimit) {
            amountCannotBeLowerThanLimitException(target, lowerLimit);
        }
    }

    private static void checkUpperLimit(TextualEntity target, int amount, int upperLimit) {
        if (amount > 1000) {
            amountCannotBeGreaterThanLimitException(target, upperLimit);
        }
    }

    private static void checkFileName(String fileName) {
        try {
            Objects.requireNonNull(fileName, "File name is null!");
            if (fileName.isBlank()) {
                throw new IllegalArgumentException("File name is blank!");
            }
        } catch (RuntimeException e) {
            logger.warning(e.getMessage());
        }
    }

    private static String trimFileAName(String fileName) {
        checkFileName(fileName);
        return fileName.trim();
    }

    private static BufferedReader getBufferedReader(String fileName, Class<?> clazz) {
        fileName = trimFileAName(fileName);
        InputStream inputStream = Objects.requireNonNull(clazz.getResourceAsStream(fileName));
        return new BufferedReader(new InputStreamReader(inputStream, UTF_8));
    }

}
