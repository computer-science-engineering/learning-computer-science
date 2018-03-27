package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.LevelOrder.ZigZagLevelOrderTraversalBt.Java;

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
        assertTimeout(Duration.ofMillis(500), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        TreeNode a = new TreeNode(3);
        TreeNode b1 = new TreeNode(9);
        TreeNode b2 = new TreeNode(20);
        TreeNode c1 = new TreeNode(15);
        TreeNode c2 = new TreeNode(7);

        a.left = b1;
        a.right = b2;
        b2.left = c1;
        b2.right = c2;
        assertTimeout(Duration.ofMillis(500), () -> {
            ArrayList<ArrayList<Integer>> expected = new ArrayList<ArrayList<Integer>>();
            expected.add(new ArrayList<Integer>(Arrays.asList(3)));
            expected.add(new ArrayList<Integer>(Arrays.asList(20, 9)));
            expected.add(new ArrayList<Integer>(Arrays.asList(15, 7)));
            ArrayList<ArrayList<Integer>> actual = Solution.zigzagLevelOrder(a);
            ArrayList<ArrayList<Integer>> actual_editorial = Solution.zigzagLevelOrder_editorial(a);
            assertEquals(expected, actual);
            assertEquals(expected, actual_editorial);
        });
    }
}