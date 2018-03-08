package Firecode.src.Problems.Level1.FlipIt.Java;

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
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        assertTimeout(Duration.ofMillis(500), () -> {
            int[][] expected = {{3,2,1},{6,5,4},{9,8,7}};
            Solution.flipItVerticalAxis(matrix);;
            assertArrayEquals(expected, matrix);
        });
    }

    @Test
    public void TrivialCase2() {
        int[][] matrix = {{1,0,0}, {0,0,1}};
        assertTimeout(Duration.ofMillis(500), () -> {
            int[][] expected = {{0,0,1},{1,0,0}};
            Solution.flipItVerticalAxis(matrix);;
            assertArrayEquals(expected, matrix);
        });
    }

    @Test
    public void SpecialCase1() {
        int[][] matrix = {{1,0,1}, {1,0,1}};
        assertTimeout(Duration.ofMillis(500), () -> {
            int[][] expected = {{1,0,1}, {1,0,1}};
            Solution.flipItVerticalAxis(matrix);;
            assertArrayEquals(expected, matrix);
        });
    }

    @Test
    public void SpecialCase2() {
        int[][] matrix = {{1,0}};
        assertTimeout(Duration.ofMillis(500), () -> {
            int[][] expected = {{0,1}};
            Solution.flipItVerticalAxis(matrix);;
            assertArrayEquals(expected, matrix);
        });
    }

    @Test
    public void SpecialCase3() {
        int[][] matrix = {{1}};
        assertTimeout(Duration.ofMillis(500), () -> {
            int[][] expected = {{1}};
            Solution.flipItVerticalAxis(matrix);;
            assertArrayEquals(expected, matrix);
        });
    }
}