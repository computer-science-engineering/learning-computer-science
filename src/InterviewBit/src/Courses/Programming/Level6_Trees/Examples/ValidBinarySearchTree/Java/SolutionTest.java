package InterviewBit.src.Courses.Programming.Level6_Trees.Examples.ValidBinarySearchTree.Java;

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
        TreeNode a = new TreeNode(1);
        TreeNode b1 = new TreeNode(2);
        TreeNode b2 = new TreeNode(3);
        a.left = b1;
        a.right = b2;
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 0;
            int actual = Solution.isValidBST(a);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        TreeNode a = new TreeNode(2);
        TreeNode b1 = new TreeNode(1);
        TreeNode b2 = new TreeNode(3);
        a.left = b1;
        a.right = b2;
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 1;
            int actual = Solution.isValidBST(a);
            assertEquals(expected, actual);
        });
    }
}