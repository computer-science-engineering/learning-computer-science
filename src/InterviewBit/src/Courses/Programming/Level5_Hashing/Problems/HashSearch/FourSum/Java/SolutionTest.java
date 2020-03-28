package InterviewBit.src.Courses.Programming.Level5_Hashing.Problems.HashSearch.FourSum.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.*;
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
        ArrayList<Integer> nums1 = new ArrayList<Integer>(Arrays.asList(1, 0, -1, 0, -2, 2));
        int[] nums2 = {1, 0, -1, 0, -2, 2};
        assertTimeout(Duration.ofMillis(700), () -> {
            ArrayList<ArrayList<Integer>> expected1 = new ArrayList<ArrayList<Integer>>();
            expected1.add(new ArrayList<Integer>(Arrays.asList(-2, -1, 1, 2)));
            expected1.add(new ArrayList<Integer>(Arrays.asList(-2, 0, 0, 2)));
            expected1.add(new ArrayList<Integer>(Arrays.asList(-1, 0, 0, 1)));
            ArrayList<ArrayList<Integer>> actual1 = Solution.fourSum(nums1, 0);
            assertEquals(expected1, actual1);
            int[][] expected2 = {{-2, -1, 1, 2}, {-2, 0, 0, 2}, {-1, 0, 0, 1}};
            int[][] actual2 = Solution.fourSumEditorial(nums2, 0);
            assertArrayEquals(expected2, actual2);
        });
    }
}