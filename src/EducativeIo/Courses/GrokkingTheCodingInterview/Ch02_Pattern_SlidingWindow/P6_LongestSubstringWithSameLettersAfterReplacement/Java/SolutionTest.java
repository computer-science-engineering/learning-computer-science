package EducativeIo.Courses.GrokkingTheCodingInterview.Ch02_Pattern_SlidingWindow.P6_LongestSubstringWithSameLettersAfterReplacement.Java;

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
        String str = "aabccbb";
        int k = 2;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 5;
            int actual = Solution.findLength(str, k);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String str = "abbcb";
        int k = 1;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 4;
            int actual = Solution.findLength(str, k);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        String str = "abccde";
        int k = 1;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 3;
            int actual = Solution.findLength(str, k);
            assertEquals(expected, actual);
        });
    }
}