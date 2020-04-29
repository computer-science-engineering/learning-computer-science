package LeetCode.src.Problems.P1_P100.P4_MedianOfTwoSortedArrays.Java;

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
        int[] nums1 = {1, 3, 8, 9, 15};
        int[] nums2 = {7, 11, 19, 21, 18, 25};
        assertTimeout(Duration.ofMillis(1000), () -> {
            double expected = 11.0;
            double actual = Solution.findMedianSortedArrays(nums1, nums2);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 6};
        assertTimeout(Duration.ofMillis(1000), () -> {
            double expected = 3.5;
            double actual = Solution.findMedianSortedArrays(nums1, nums2);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase1() {
        int[] nums1 = {2};
        int[] nums2 = {};
        assertTimeout(Duration.ofMillis(1000), () -> {
            double expected = 2.0;
            double actual = Solution.findMedianSortedArrays(nums1, nums2);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase2() {
        int[] nums1 = {1,2,3,5,6};
        int[] nums2 = {4};
        assertTimeout(Duration.ofMillis(1000), () -> {
            double expected = 3.5;
            double actual = Solution.findMedianSortedArrays(nums1, nums2);
            assertEquals(expected, actual);
        });
    }
}