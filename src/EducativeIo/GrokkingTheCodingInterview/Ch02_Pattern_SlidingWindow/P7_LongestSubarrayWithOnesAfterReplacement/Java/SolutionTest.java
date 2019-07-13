package EducativeIo.GrokkingTheCodingInterview.Ch02_Pattern_SlidingWindow.P7_LongestSubarrayWithOnesAfterReplacement.Java;

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
        int[] arr = new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 };
        int k = 2;
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 6;
            int actual = Solution.findLength(arr, k);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] arr = new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 };
        int k = 3;
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 9;
            int actual = Solution.findLength(arr, k);
            assertEquals(expected, actual);
        });
    }
}