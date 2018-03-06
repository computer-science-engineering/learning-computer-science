package InterviewBit.src.Courses.Programming.Level6_Trees.Examples.NextGreaterNumberBst.Java;

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
    public void TrivialCase1() {
        //root level 0
        TreeNode a = new TreeNode(100);
        //Level 1
        TreeNode b1 = new TreeNode(98);
        TreeNode b2 = new TreeNode(102);
        a.left = b1;
        a.right = b2;        
        //Level 2
        TreeNode c1 = new TreeNode(96);
        TreeNode c2 = new TreeNode(99);
        b1.left = c1;
        b1.right = c2;
        //Level 3
        TreeNode d = new TreeNode(97);
        c1.right = d;
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 98;
            int actual1 = Solution.getSuccessor(a, 97).val;
            assertEquals(expected, actual1);
            int actual2 = Solution.getSuccessor_Editorial(a, 97).val;
            assertEquals(expected, actual2);
        });
    }
}