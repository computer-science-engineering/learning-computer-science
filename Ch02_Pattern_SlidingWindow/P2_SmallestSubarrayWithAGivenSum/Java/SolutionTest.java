package EducativeIo.Courses.GrokkingTheCodingInterview.Ch02_Pattern_SlidingWindow.P2_SmallestSubarrayWithAGivenSum.Java;

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
        int[] arr = new int[] { 2, 1, 5, 2, 3, 2 };
        int S = 7;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 2;
            int actual = Solution.findMinSubArray(S, arr);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] arr = new int[] { 2, 1, 5, 2, 8 };
        int S = 7;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 1;
            int actual = Solution.findMinSubArray(S, arr);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        int[] arr = new int[] { 3, 4, 1, 1, 6 };
        int S = 8;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 3;
            int actual = Solution.findMinSubArray(S, arr);
            assertEquals(expected, actual);
        });
    }
}