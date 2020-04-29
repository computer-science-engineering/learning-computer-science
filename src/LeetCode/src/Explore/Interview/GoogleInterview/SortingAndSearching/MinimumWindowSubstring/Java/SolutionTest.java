package LeetCode.src.Explore.Interview.GoogleInterview.SortingAndSearching.MinimumWindowSubstring.Java;

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
        assertTimeout(Duration.ofMillis(1000), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        assertTimeout(Duration.ofMillis(1000), () -> {
            String expected = "BANC";
            String actual = Solution.minWindow(s, t);
            String actual_opt = Solution.minWindow_opt(s, t);
            assertEquals(expected, actual);
            assertEquals(expected, actual_opt);
        });
    }
}