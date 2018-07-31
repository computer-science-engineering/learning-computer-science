package LeetCode.src.Problems.P301_P400.P311_SparseMatrixMultiplication.Java;

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
        int[][] A = {{1, 0, 0}, {-1, 0, 3}};
        int[][] B = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};
        assertTimeout(Duration.ofMillis(500), () -> {
            int[][] expected = {{7, 0, 0}, {-7, 0, 3}};
            int[][] actual = Solution.multiply(A, B);
            int[][] actual_opt = Solution.multiply_opt(A, B);
            assertArrayEquals(expected, actual);
            assertArrayEquals(expected, actual_opt);
        });
    }
}