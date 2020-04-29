package LeetCode.src.Problems.P301_P400.P350_IntersectionOfTwoArrays2.Java;

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
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int[] expected = {2, 2};
            int[] actual = Solution.intersect(nums1, nums2);
            assertArrayEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {1, 1};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int[] expected = {1};
            int[] actual = Solution.intersect(nums1, nums2);
            assertArrayEquals(expected, actual);
        });
    }
}