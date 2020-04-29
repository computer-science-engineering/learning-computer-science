package LeetCode.src.Explore.Interview.GoogleInterview.SortingAndSearching.PacificAtlanticWaterFlow.Java;

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
        assertTimeout(Duration.ofMillis(1000), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        int[][] matrix = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        };
        assertTimeout(Duration.ofMillis(1000), () -> {
            List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0,4),
                Arrays.asList(1,3),
                Arrays.asList(1,4),
                Arrays.asList(2,2),
                Arrays.asList(3,0),
                Arrays.asList(3,1),
                Arrays.asList(4,0)
            );
            List<int[]> result = Solution.pacificAtlantic(matrix);
            List<List<Integer>> actual = new ArrayList<>();
            for (int[] intArray : result) {
                List<Integer> nestedList = new ArrayList<>();
                for (int item : intArray) {
                    nestedList.add(item);
                }
                actual.add(nestedList);
            }
            assertEquals(expected, actual);
        });
    }
}