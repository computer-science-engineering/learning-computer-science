package LeetCode.src.Explore.Interview.GoogleInterview.SortingAndSearching.FindKPairsWithSmallestSums.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
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
        assertTimeout(Duration.ofMillis(500), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 3;
        assertTimeout(Duration.ofMillis(500), () -> {
            List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1,2), 
                Arrays.asList(1,4), 
                Arrays.asList(1,6));
            List<int[]> result_1 = Solution.kSmallestPairs_1(nums1, nums2, k);
            List<int[]> result = Solution.kSmallestPairs(nums1, nums2, k);  

            List<List<Integer>> actual_1 = new ArrayList<>();
            for (int[] intArray : result_1) {
                List<Integer> innerListActual = new ArrayList<>();
                for (int item : intArray) {                    
                    innerListActual.add(item);
                }
                actual_1.add(innerListActual);
            }

            List<List<Integer>> actual = new ArrayList<>();
            for (int[] intArray : result) {
                List<Integer> innerListActual = new ArrayList<>();
                for (int item : intArray) {                    
                    innerListActual.add(item);
                }
                actual.add(innerListActual);
            }
            
            assertEquals(expected, actual_1);
            assertEquals(expected, actual);
        });
    }
}