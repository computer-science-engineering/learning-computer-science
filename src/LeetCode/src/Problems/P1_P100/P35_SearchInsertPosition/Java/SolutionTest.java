package LeetCode.src.Problems.P1_P100.P35_SearchInsertPosition.Java;

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
        int[] nums = {1,3,5,6};
        int target = 5;
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 2;
            int actual = Solution.searchInsert(nums, target);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] nums = {1,3,5,6};
        int target = 7;
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 4;
            int actual = Solution.searchInsert(nums, target);
            assertEquals(expected, actual);
        });
    }
}