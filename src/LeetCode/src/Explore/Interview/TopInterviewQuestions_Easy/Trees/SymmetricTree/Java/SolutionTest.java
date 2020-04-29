package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.Trees.SymmetricTree.Java;

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
            boolean expected = true;
            boolean actual_recursive = Solution.isSymmetric(root);
            assertEquals(expected, actual_recursive);
            boolean actual_iterative = Solution.isSymmetric_Iterative(root);
            assertEquals(expected, actual_iterative);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] values = {
            1,
            2, 2,
            -1, 3, -1, 3};
        TreeNode root = TreeNode.fromArray(values);
        assertTimeout(Duration.ofMillis(1000), () -> {
            boolean expected = false;
            boolean actual_recursive = Solution.isSymmetric(root);
            assertEquals(expected, actual_recursive);
            boolean actual_iterative = Solution.isSymmetric_Iterative(root);
            assertEquals(expected, actual_iterative);
        });
    }
}