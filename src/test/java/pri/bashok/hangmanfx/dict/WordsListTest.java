package pri.bashok.hangmanfx.dict;

import org.junit.Before;
import org.junit.Test;

import java.nio.file.Paths;

import static org.junit.Assert.*;

public class WordsListTest {
    private WordsList instance;

    @Before
    public void init() {
        String path = Paths.get("src", "test", "resources", "en_list.txt")
                .toString();
        instance = WordsList.build(path);
    }

    @Test
    public void testSelect() {
        String selected = instance.selectRandom();
        assertNotNull(selected);
        for (int i = 0; i < 8; i ++) {
            instance.selectRandom();
        }
        assertNull(instance.selectRandom());
    }
}
