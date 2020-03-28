package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.Trees.ConvertSortedArrayToBinarySearchTree.Java;

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
        int[] nums = {-10,-3,0,5,9};
        assertTimeout(Duration.ofMillis(700), () -> {
            List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0),
                Arrays.asList(-10, 5),
                Arrays.asList(-3, 9)
            );
            TreeNode result = Solution.sortedArrayToBST(nums);
            List<List<Integer>> actual = Solution.levelOrder(result);
            assertEquals(expected, actual);
        });
    }
}