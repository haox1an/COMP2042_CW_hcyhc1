

import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class FrogScoreTest {
    File file;
    List<Integer> list;
    List<Integer> expected;

    /**
     * Test if file has been created
     */
    @Test
    void createFile() {
        file = new File("src/main/resources/File/score.txt");
        assertTrue(file.exists(), "File is created");
    }

    /**
     * Test if the array list of score can sort the number
     * And if it will only hold 5 numbers
     */
    @Test
    void addScore() {
        list = new ArrayList<>();
        expected = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        expected.add(7);
        expected.add(6);
        expected.add(5);
        expected.add(4);
        expected.add(3);

        list.sort(Collections.reverseOrder());
        list = list.stream().limit(5).collect(Collectors.toList());
        assertSame(5, list.size(), "LeaderBoard has 5 elements");
        assertNotSame( list.size() > 5, list.size(),"Error: LeaderBoard hold more than 5 elements");
        assertEquals(expected, list, "Leaderboard is sorted");
    }
}