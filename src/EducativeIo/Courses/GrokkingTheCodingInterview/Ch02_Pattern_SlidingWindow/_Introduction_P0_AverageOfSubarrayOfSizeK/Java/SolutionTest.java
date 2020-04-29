package EducativeIo.Courses.GrokkingTheCodingInterview.Ch02_Pattern_SlidingWindow._Introduction_P0_AverageOfSubarrayOfSizeK.Java;

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
      int K = 5;
      int[] arr = new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2 };
        assertTimeout(Duration.ofMillis(1000), () -> {
            double[] expected = new double[] {2.2, 2.8, 2.4, 3.6, 2.8};       
            double[] actual_Naive = Solution.findAverages_naive(K, arr);
            double[] actual_SlidingWindow = Solution.findAverages_slidingWindow(K, arr);
            assertArrayEquals(expected, actual_Naive);
            assertArrayEquals(expected, actual_SlidingWindow);
        });
    }
}