package EducativeIo.GrokkingTheCodingInterview.Ch08_TreeBreadthFirstSearch.PC2_RightViewOfABinaryTree.Java;

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
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        assertTimeout(Duration.ofMillis(500), () -> {
            List<Integer> expected = Arrays.asList(12, 1, 5, 3);
            List<TreeNode> result = Solution.traverse(root);
            List<Integer> actual = new ArrayList<>();
            for (TreeNode node : result) {
                actual.add(node.val);
            }
            assertEquals(expected, actual);
        });
    }
}
