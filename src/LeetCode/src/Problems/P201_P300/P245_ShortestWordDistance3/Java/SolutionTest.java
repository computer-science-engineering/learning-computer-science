package LeetCode.src.Problems.P201_P300.P245_ShortestWordDistance3.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class SolutionTest {
    
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
        assertTimeout(Duration.ofMillis(700), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }

    @Test
    public void TrivialCase1() {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "makes";
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 1;
            int actual = Solution.shortestWordDistance(words, word1, word2);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes";
        String word2 = "makes";
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 3;
            int actual = Solution.shortestWordDistance(words, word1, word2);
            assertEquals(expected, actual);
        });
    }
}