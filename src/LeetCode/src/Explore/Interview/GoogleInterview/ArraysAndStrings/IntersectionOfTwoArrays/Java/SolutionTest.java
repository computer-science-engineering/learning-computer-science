package LeetCode.src.Explore.Interview.GoogleInterview.ArraysAndStrings.IntersectionOfTwoArrays.Java;

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
        int[] nums1 = {1,2,2,1}, nums2 = {2,2};
        assertTimeout(Duration.ofMillis(500), () -> {
            int[] expected = {2};
            int[] actual = Solution.intersection(nums1, nums2);
            assertArrayEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
        assertTimeout(Duration.ofMillis(500), () -> {
            int[] expected = {4,9};
            int[] actual = Solution.intersection(nums1, nums2);
            assertArrayEquals(expected, actual);
        });
    }
}