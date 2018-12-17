package LeetCode.src.Explore.Interview.GoogleInterview.ArraysAndStrings.LongestSubstringWithAtMostKDistinctCharacters.Java;

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
        String s = "eceba";
        int k = 2;
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 3;
            int actual = Solution.lengthOfLongestSubstringKDistinct(s, k);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String s = "aa";
        int k = 1;
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 2;
            int actual = Solution.lengthOfLongestSubstringKDistinct(s, k);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase1() {
        String s = "aa";
        int k = 0;
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 0;
            int actual = Solution.lengthOfLongestSubstringKDistinct(s, k);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase2() {
        String s = "aba";
        int k = 1;
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 1;
            int actual = Solution.lengthOfLongestSubstringKDistinct2(s, k);
            assertEquals(expected, actual);
        });
    }
}