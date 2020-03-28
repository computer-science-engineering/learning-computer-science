package LeetCode.src.Explore.Interview.GoogleInterview.ArraysAndStrings.ImageSmoother.Java;

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
        assertTimeout(Duration.ofMillis(700), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        int[][] M = {
            {1,1,1},
            {1,0,1},
            {1,1,1}
        };
        assertTimeout(Duration.ofMillis(700), () -> {
            int[][] expected = {
                {0,0,0},
                {0,0,0},
                {0,0,0}
            };
            int[][] actual = Solution.imageSmoother(M);
            assertArrayEquals(expected, actual);
        });
    }
}