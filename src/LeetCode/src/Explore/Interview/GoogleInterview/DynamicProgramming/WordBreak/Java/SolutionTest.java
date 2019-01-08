package LeetCode.src.Explore.Interview.GoogleInterview.DynamicProgramming.WordBreak.Java;

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
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen");
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = true;
            boolean actual = Solution.wordBreak(s, wordDict);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = true;
            boolean actual = Solution.wordBreak(s, wordDict);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = false;
            boolean actual = Solution.wordBreak(s, wordDict);
            assertEquals(expected, actual);
        });
    }
}