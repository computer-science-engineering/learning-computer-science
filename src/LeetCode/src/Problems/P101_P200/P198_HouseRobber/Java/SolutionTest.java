package LeetCode.src.Problems.P101_P200.P198_HouseRobber.Java;

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
        int[] nums = {2,7,9,3,1};
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 12;
            int actual = Solution.rob(nums);
            int actual_opt = Solution.rob_opt(nums);
            assertEquals(expected, actual);
            assertEquals(expected, actual_opt);
        });
    }
}