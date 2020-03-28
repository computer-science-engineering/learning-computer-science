package LeetCode.src.Problems.P201_P300.P236_LowestCommonAncestorOfABinaryTree.Java;

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
        int[] values = {
            1,
            5, 1,
            6, 2, 0, 8
            -1, -1, 7, 4, -1, -1};
        TreeNode root = TreeNode.fromArray(values);
        int p = 5;        
        int q = 4;
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 5;
            int actual = Solution.lowestCommonAncestor(root, p, q).val;
            assertEquals(expected, actual);
        });
    }
}