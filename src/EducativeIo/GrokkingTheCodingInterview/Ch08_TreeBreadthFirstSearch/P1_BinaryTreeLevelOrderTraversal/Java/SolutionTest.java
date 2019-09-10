package EducativeIo.GrokkingTheCodingInterview.Ch08_TreeBreadthFirstSearch.P1_BinaryTreeLevelOrderTraversal.Java;

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
        assertTimeout(Duration.ofMillis(500), () -> {
            String[] args = new String[0];
            assertAll(() -> Solution.main(args));
        });
    }

    @Test
    public void TrivialCase1() {
        int[] values = {12, 7, 1, 9, -1, 10, 5};
        TreeNode root = TreeNode.fromArray(values);
        assertTimeout(Duration.ofMillis(500), () -> {
            List<List<Integer>> expected =
                    Arrays.asList(Arrays.asList(12), Arrays.asList(7, 1), Arrays.asList(9, 10, 5));
            List<List<Integer>> actual = Solution.traverse(root);
            assertEquals(expected, actual);
        });
    }
}
