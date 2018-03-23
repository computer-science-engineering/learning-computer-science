package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.BstTraversal.BstIterator.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class SolutionTest {
    
    Solution solution;
    
    @BeforeEach
    public void setUp() throws Exception {
        TreeNode a = new TreeNode(5);
        TreeNode b1 = new TreeNode(3);
        TreeNode b2 = new TreeNode(10);
        
        TreeNode c1 = new TreeNode(1);
        TreeNode c2 = new TreeNode(4);
        TreeNode c3 = new TreeNode(7);
        TreeNode c4 = new TreeNode(12);

        TreeNode d1 = new TreeNode(10);

        TreeNode e1 = new TreeNode(9);
        TreeNode e2 = new TreeNode(11);

        a.left = b1;
        a.right = b2;

        b1.left = c1;
        b1.right = c2;
        b2.left = c3;
        b2.right = c4;

        c4.left = d1;

        d1.left = e1;
        d1.right = e2;
        solution = new Solution(a);
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
        assertTimeout(Duration.ofMillis(500), () -> {
            int[] expected = { 1, 3, 4, 5, 7, 10, 9, 10, 11, 12 };
            int[] actual = new int[10];
            int i = 0;
            while (solution.hasNext()) {
                actual[i++] = solution.next();
            }
            assertArrayEquals(expected, actual);
        });
    }
}