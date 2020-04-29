package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.Trees.BinaryTreeLevelOrderTraversal.Java;

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
        assertTimeout(Duration.ofMillis(1000), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        int[] values = {
            1,
            2, 2,
            3, 4, 4, 3};
        TreeNode root = TreeNode.fromArray(values);
        assertTimeout(Duration.ofMillis(1000), () -> {
            List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1), 
                Arrays.asList(2,2), 
                Arrays.asList(3,4,4,3));
            List<List<Integer>> actual = Solution.levelOrder(root);
            assertEquals(expected, actual);
        });
    }
}