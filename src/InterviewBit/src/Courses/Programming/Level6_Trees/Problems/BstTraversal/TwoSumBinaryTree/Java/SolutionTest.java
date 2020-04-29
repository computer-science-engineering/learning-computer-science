package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.BstTraversal.TwoSumBinaryTree.Java;

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
        TreeNode A = new TreeNode(10);
        TreeNode B1 = new TreeNode(9);
        TreeNode B2 = new TreeNode(20);
        A.left = B1;
        A.right = B2;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 1;
            int actual = Solution.t2Sum(A, 19);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        TreeNode A = new TreeNode(10);
        TreeNode B1 = new TreeNode(9);
        TreeNode B2 = new TreeNode(20);
        A.left = B1;
        A.right = B2;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 0;
            int actual = Solution.t2Sum(A, 40);
            assertEquals(expected, actual);
        });
    }
}