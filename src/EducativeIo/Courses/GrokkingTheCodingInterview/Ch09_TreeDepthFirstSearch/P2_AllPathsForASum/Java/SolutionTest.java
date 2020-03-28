package EducativeIo.Courses.GrokkingTheCodingInterview.Ch09_TreeDepthFirstSearch.P2_AllPathsForASum.Java;

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
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        assertTimeout(Duration.ofMillis(700), () -> {
            List<List<Integer>> expected =
                    Arrays.asList(Arrays.asList(12, 7, 4), Arrays.asList(12, 1, 10));
            List<List<Integer>> actual = Solution.findPaths(root, sum);
            assertEquals(expected, actual);
        });
    }
}
