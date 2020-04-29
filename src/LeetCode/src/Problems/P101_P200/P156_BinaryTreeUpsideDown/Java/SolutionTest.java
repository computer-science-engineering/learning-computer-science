package LeetCode.src.Problems.P101_P200.P156_BinaryTreeUpsideDown.Java;

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
        int[] values = {
            1,
            2, 3,
            4, 5, -1, -1};
        TreeNode root1 = TreeNode.fromArray(values);
        TreeNode root2 = TreeNode.fromArray(values);
        assertTimeout(Duration.ofMillis(1000), () -> {
            List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(4),
                Arrays.asList(5, 2),
                Arrays.asList(3, 1)
            );
            TreeNode result = Solution.upsideDownBinaryTree(root1);
            ArrayList<ArrayList<Integer>> actual = Solution.levelOrder(result);
            assertEquals(expected, actual);
            TreeNode result_iterative = Solution.upsideDownBinaryTree_iterative(root2);
            ArrayList<ArrayList<Integer>> actual_iterative = Solution.levelOrder(result_iterative);
            assertEquals(expected, actual_iterative);
        });
    }
}