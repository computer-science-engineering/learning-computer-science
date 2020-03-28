package LeetCode.src.Problems.P501_P600.P515_FindLargestValueInEachTreeRow.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
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
        assertTimeout(Duration.ofMillis(700), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        int[] values = {
            1,
            3, 2,
            5, 3, -1, 9};
        TreeNode root = TreeNode.fromArray(values);
        assertTimeout(Duration.ofMillis(700), () -> {
            List<Integer> expected = Arrays.asList(1, 3, 9);
            List<Integer> actual = Solution.largestValues(root);
            assertEquals(expected, actual);
        });
    }
}