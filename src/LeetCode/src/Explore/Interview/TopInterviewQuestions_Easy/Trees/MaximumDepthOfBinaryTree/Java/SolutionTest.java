package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.Trees.MaximumDepthOfBinaryTree.Java;

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
        assertTimeout(Duration.ofMillis(500), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        int[] values = {
            5,
            4, 8,
            11, -1, 13, 4,
            7, 2, -1, -1, -1, -1, 5, 1};
            TreeNode root = TreeNode.fromArray(values);
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 4;
            int actual_recursive = Solution.maxDepth(root);
            assertEquals(expected, actual_recursive);
            int actual_iterative_dfs = Solution.maxDepth_Iterative_dfs(root);
            assertEquals(expected, actual_iterative_dfs);
            int actual_iterative_bfs = Solution.maxDepth_Iterative_bfs(root);
            assertEquals(expected, actual_iterative_bfs);
        });
    }
}