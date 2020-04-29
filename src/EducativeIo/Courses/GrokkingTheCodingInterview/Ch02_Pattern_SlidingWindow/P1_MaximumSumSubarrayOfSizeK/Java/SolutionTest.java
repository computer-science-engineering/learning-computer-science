package EducativeIo.Courses.GrokkingTheCodingInterview.Ch02_Pattern_SlidingWindow.P1_MaximumSumSubarrayOfSizeK.Java;

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
        int[] arr = new int[] { 2, 1, 5, 1, 3, 2 };
        int k = 3;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 9;
            int actual_naive = Solution.findMaxSumSubArray_naive(k, arr);
            int actual = Solution.findMaxSumSubArray(k, arr);
            assertEquals(expected, actual_naive);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] arr = new int[] { 2, 3, 4, 1, 5 };
        int k = 2;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 7;
            int actual_naive = Solution.findMaxSumSubArray_naive(k, arr);
            int actual = Solution.findMaxSumSubArray(k, arr);
            assertEquals(expected, actual_naive);
            assertEquals(expected, actual);
        });
    }
}