package LeetCode.src.Problems.P201_P300.P244_ShortedWordDistance2.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class WordDistanceTest {
    
    Solution solution;
    
    @BeforeEach
    public void setUp() throws Exception {
        solution = new Solution();
    }
    
    @AfterEach
    public void tearDown() throws Exception {
        solution = null;
    }
    
    @Test
    public void MainFunction() {
        assertTimeout(Duration.ofMillis(1000), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "practice";
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 3;
            WordDistance obj = new WordDistance(words);
            int actual = obj.shortest(word1, word2);
            int actual_hashMap = obj.shortest_hashMap(word1, word2);
            assertEquals(expected, actual);
            assertEquals(expected, actual_hashMap);
        });
    }

    @Test
    public void TrivialCase2() {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "makes";
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 1;
            WordDistance obj = new WordDistance(words);
            int actual = obj.shortest(word1, word2);
            int actual_hashMap = obj.shortest_hashMap(word1, word2);
            assertEquals(expected, actual);
            assertEquals(expected, actual_hashMap);
        });
    }
}