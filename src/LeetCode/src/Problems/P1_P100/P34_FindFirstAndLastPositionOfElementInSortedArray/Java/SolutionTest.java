package LeetCode.src.Problems.P1_P100.P34_FindFirstAndLastPositionOfElementInSortedArray.Java;

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
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int[] expected = {3,4};
            int[] actual = Solution.searchRange(nums, target);
            assertArrayEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] nums = {5,7,7,8,8,10};
        int target = 6;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int[] expected = {-1,-1};
            int[] actual = Solution.searchRange(nums, target);
            assertArrayEquals(expected, actual);
        });
    }
}