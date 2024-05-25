package pri.bashok.hangmanfx.service;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton that loads the list of words in the game, and uses Iterator pattern to randomise
 * Requires the data file to be present in the correct location
 */
public class Hangman {
    private static Hangman instance;
    private final List<String> words;
    private Iterator<String> iterator;

    private Hangman() {
        words = new ArrayList<>();
        iterator = Collections.emptyIterator();
    }

    public static Hangman build(String file) throws IOException {
        if (instance == null) {
            instance = new Hangman();
            instance.load(file);
        }
        return instance;
    }

    private void load(String file) throws IOException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(file);
        if (null == inputStream) {
            throw new FileNotFoundException("File, " + file + " was not found.");
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while((line = reader.readLine()) != null) {
            words.add(line);
        }
        Collections.shuffle(words);
        iterator = words.iterator();
    }

    public String selectNext() {
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null;  // No more words left to play
    }

    public boolean isAMatch(String dictWord, String guessWord) {
        return dictWord.equalsIgnoreCase(guessWord);
    }
}
