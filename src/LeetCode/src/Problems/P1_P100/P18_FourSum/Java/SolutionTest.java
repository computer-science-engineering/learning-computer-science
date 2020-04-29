package LeetCode.src.Problems.P1_P100.P18_FourSum.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
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
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        assertTimeout(Duration.ofMillis(1000), () -> {
            List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(-2, 0, 0, 2),
                Arrays.asList(-1, 0, 0, 1),
                Arrays.asList(-2, -1, 1, 2)
            );
            List<List<Integer>> actual = Solution.fourSum(nums, target);
            assertEquals(expected, actual);
        });
    }
}