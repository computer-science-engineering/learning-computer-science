package EducativeIo.Courses.GrokkingTheCodingInterview.Ch09_TreeDepthFirstSearch.PC2_PathWithMaximumSum.Java;

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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 6;
            int actual = Solution.findMaximumPathSum(root);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 31;
            int actual = Solution.findMaximumPathSum(root);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = -1;
            int actual = Solution.findMaximumPathSum(root);
            assertEquals(expected, actual);
        });
    }
}
