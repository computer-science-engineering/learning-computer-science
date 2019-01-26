package LeetCode.src.Problems.P1_P100.P28_ImplementStrStr.Java;

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
        String haystack = "hello";
        String needle = "ll";
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 2;
            int actual = Solution.strStr(haystack, needle);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String haystack = "aaaaa";
        String needle = "bba";
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = -1;
            int actual = Solution.strStr(haystack, needle);
            assertEquals(expected, actual);
        });
    }
}