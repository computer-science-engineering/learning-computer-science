package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.TwoTrees.SymmetricBinaryTree.Java;

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
        TreeNode A = new TreeNode(1);
        TreeNode B1 = new TreeNode(2);
        TreeNode B2 = new TreeNode(2);
        TreeNode C1 = new TreeNode(3);
        TreeNode C2 = new TreeNode(4);
        TreeNode C3 = new TreeNode(4);
        TreeNode C4 = new TreeNode(3);
        A.left = B1;
        A.right = B2;
        B1.left = C1;
        B1.right = C2;
        B2.left = C3;
        B2.right = C4;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 1;
            int actual = Solution.isSymmetric(A);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        TreeNode M = new TreeNode(1);
        TreeNode N1 = new TreeNode(2);
        TreeNode N2 = new TreeNode(2);
        TreeNode O1 = new TreeNode(3);
        TreeNode O2 = new TreeNode(3);
        M.left = N1;
        M.right = N2;
        N1.right = O1;
        N2.right = O2;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 0;
            int actual = Solution.isSymmetric(M);
            assertEquals(expected, actual);
        });
    }
}