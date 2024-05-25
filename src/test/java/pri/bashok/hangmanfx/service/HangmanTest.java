package pri.bashok.hangmanfx.service;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class HangmanTest {
    private Hangman instance;

    @Before
    public void init() {
        try {
            instance = Hangman.build("en_list.txt");
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Test
    public void testSelect() {
        String selected = instance.selectNext();
        assertNotNull(selected);
        for (int i = 0; i < 8; i ++) {
            instance.selectNext();
        }
        assertNull(instance.selectNext());
    }

    @Test
    public void testIsAMatch() {
        String selected = instance.selectNext();
        assertNotNull(selected);
        assertFalse(instance.isAMatch(selected, "random word"));
        assertTrue(instance.isAMatch("word", "WoRd"));
        assertTrue(instance.isAMatch("word", "word"));
    }
}
