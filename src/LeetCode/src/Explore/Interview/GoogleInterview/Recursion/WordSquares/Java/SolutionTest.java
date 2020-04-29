package LeetCode.src.Explore.Interview.GoogleInterview.Recursion.WordSquares.Java;

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
        assertTimeout(Duration.ofMillis(1000), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        String[] words = {"abat","baba","atan","atal"};
        assertTimeout(Duration.ofMillis(1000), () -> {
            List<List<String>> expected = Arrays.asList(
                Arrays.asList("baba", "abat", "baba", "atan"),
                Arrays.asList("baba", "abat", "baba", "atal")
                );
            List<List<String>> actual = Solution.wordSquares(words);
            assertEquals(expected, actual);
        });
    }
}