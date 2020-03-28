package LeetCode.src.Explore.Interview.GoogleInterview.SortingAndSearching.NextGreaterElement1.Java;

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
        int[] nums1 = {4,1,2}, nums2 = {1,3,4,2};
        assertTimeout(Duration.ofMillis(700), () -> {
            int[] expected = {-1, 3, -1};
            int[] actual = Solution.nextGreaterElement(nums1, nums2);
            assertArrayEquals(expected, actual);
        });
    }
}