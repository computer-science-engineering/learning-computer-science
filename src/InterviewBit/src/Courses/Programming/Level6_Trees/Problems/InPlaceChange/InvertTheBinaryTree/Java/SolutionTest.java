package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.InPlaceChange.InvertTheBinaryTree.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;

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
        TreeNode c1 = new TreeNode(4);
        TreeNode c2 = new TreeNode(5);
        TreeNode c3 = new TreeNode(6);
        TreeNode c4 = new TreeNode(7);

        a.left = b1;
        a.right = b2;
        b1.left = c1;
        b1.right = c2;
        b2.left = c3;
        b2.right = c4;
        assertTimeout(Duration.ofMillis(500), () -> {
            TreeNode x = new TreeNode(1);

            TreeNode y1 = new TreeNode(3);
            TreeNode y2 = new TreeNode(2);

            TreeNode z1 = new TreeNode(7);
            TreeNode z2 = new TreeNode(6);
            TreeNode z3 = new TreeNode(5);
            TreeNode z4 = new TreeNode(4);

            x.left = y1;
            x.right = y2;
            y1.left = z1;
            y1.right = z2;
            y2.left = z3;
            y2.right = z4;
            
            ArrayList<Integer> expectedArray = Solution.levelOrder(x);
            TreeNode actual = Solution.invertTree(a);
            ArrayList<Integer> actualArray = Solution.levelOrder(actual);
            assertEquals(expectedArray, actualArray);
        });
    }
}