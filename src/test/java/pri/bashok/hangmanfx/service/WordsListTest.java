package pri.bashok.hangmanfx.service;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class WordsListTest {
    private Hangman instance;

    @Before
    public void init() {
        String path = Paths.get("src", "test", "resources", "en_list.txt")
                .toString();
        try {
            instance = Hangman.build(path);
        } catch (IOException e) {

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
}
