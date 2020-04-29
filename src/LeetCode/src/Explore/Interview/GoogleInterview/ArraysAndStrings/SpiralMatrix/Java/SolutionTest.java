package LeetCode.src.Explore.Interview.GoogleInterview.ArraysAndStrings.SpiralMatrix.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
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
        int[][] matrix = new int[][] {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        assertTimeout(Duration.ofMillis(1000), () -> {
            List<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5));
            List<Integer> actual = Solution.spiralOrder(matrix);
            assertEquals(expected, actual);
        });
    }
}