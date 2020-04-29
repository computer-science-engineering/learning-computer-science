package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.Array.PlusOne.Java;

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
        int[] digits = {4,3,2,1};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int[] expected = {4,3,2,2};
            int[] actual = Solution.plusOne(digits);
            assertArrayEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] digits = {4,3,2,9};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int[] expected = {4,3,3,0};
            int[] actual = Solution.plusOne(digits);
            assertArrayEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        int[] digits = {9,9,9,9};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int[] expected = {1,0,0,0,0};
            int[] actual = Solution.plusOne(digits);
            assertArrayEquals(expected, actual);
        });
    }
}