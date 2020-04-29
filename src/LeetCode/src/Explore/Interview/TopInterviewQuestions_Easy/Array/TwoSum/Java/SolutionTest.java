package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.Array.TwoSum.Java;

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
        int[] nums = {2, 7, 11, 15};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int[] expected = {0, 1};
            int[] actual = Solution.twoSum(nums, 9);
            assertArrayEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] nums = {3, 2, 4};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int[] expected = {1, 2};
            int[] actual = Solution.twoSum(nums, 6);
            assertArrayEquals(expected, actual);
        });
    }
}