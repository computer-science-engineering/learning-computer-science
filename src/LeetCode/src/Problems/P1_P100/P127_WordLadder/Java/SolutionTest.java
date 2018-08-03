package LeetCode.src.Problems.P1_P100.P127_WordLadder.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

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
        assertTimeout(Duration.ofMillis(500), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log", "cog");
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 5;
            int actual = Solution.ladderLength(beginWord, endWord, wordList);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 0;
            int actual = Solution.ladderLength(beginWord, endWord, wordList);
            assertEquals(expected, actual);
        });
    }
}