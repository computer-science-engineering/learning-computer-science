package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.Traversal.VerticalOrderTraversalOfBinaryTree.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

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
        TreeNode a = new TreeNode(6);
        TreeNode b1 = new TreeNode(3);
        TreeNode b2 = new TreeNode(7);
        a.left = b1;
        a.right = b2;
        TreeNode c1 = new TreeNode(2);
        TreeNode c2 = new TreeNode(5);
        TreeNode c3 = new TreeNode(9);
        b1.left = c1;
        b1.right = c2;
        b2.right = c3;
        assertTimeout(Duration.ofMillis(1000), () -> {
            ArrayList<ArrayList<Integer>> expected = new ArrayList<ArrayList<Integer>>();
            expected.add(new ArrayList<Integer>(Arrays.asList(2)));
            expected.add(new ArrayList<Integer>(Arrays.asList(3)));
            expected.add(new ArrayList<Integer>(Arrays.asList(6, 5)));
            expected.add(new ArrayList<Integer>(Arrays.asList(7)));
            expected.add(new ArrayList<Integer>(Arrays.asList(9)));
            ArrayList<ArrayList<Integer>> actual = Solution.verticalOrderTraversal(a);
            assertEquals(expected, actual);
        });
    }
}