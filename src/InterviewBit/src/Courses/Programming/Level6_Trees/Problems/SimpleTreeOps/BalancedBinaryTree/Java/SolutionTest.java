package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.SimpleTreeOps.BalancedBinaryTree.Java;

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
        TreeNode B2 = new TreeNode(3);
        A.left = B1;
        A.right = B2;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 1;
            int actual = Solution.isBalanced(A);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        TreeNode a = new TreeNode(3);        
        TreeNode b = new TreeNode(2);        
        TreeNode c = new TreeNode(1);
        a.left = b;
        b.left = c;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 0;
            int actual = Solution.isBalanced(a);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        TreeNode M = new TreeNode(1);        
        TreeNode N1 = new TreeNode(2);        
        TreeNode N2 = new TreeNode(3);       
        TreeNode O = new TreeNode(4);       
        TreeNode P = new TreeNode(5);
        M.left = N1;
        M.right = N2;
        N2.left = O;
        O.right = P;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 0;
            int actual = Solution.isBalanced(M);
            assertEquals(expected, actual);
        });
    }
}