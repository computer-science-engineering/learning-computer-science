package LeetCode.src.Problems.P1_P100.P76_MinimumWindowSubstring.Java;

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
        assertTimeout(Duration.ofMillis(500), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        assertTimeout(Duration.ofMillis(500), () -> {
            String expected = "BANC";
            String actual = Solution.minWindow(s, t);
            assertEquals(expected, actual);
            String actual_opt = Solution.minWindow_opt(s, t);
            assertEquals(expected, actual_opt);
        });
    }
}