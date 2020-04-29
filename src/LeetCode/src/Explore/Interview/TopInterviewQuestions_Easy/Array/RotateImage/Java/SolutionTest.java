package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.Array.RotateImage.Java;

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
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
            Solution.rotate(matrix);
            int[][] actual = matrix;
            assertArrayEquals(expected, actual);
        });
    }
}