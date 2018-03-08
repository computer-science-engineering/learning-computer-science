package InterviewBit.src.Courses.Programming.Level6_Trees.Examples.NextGreaterNumberBst.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class SolutionTest {
    
    Solution solution;
    TreeNode a = null;
    
    @BeforeEach
    public void setUp() throws Exception {
        solution = new Solution();
        //root level 0
        a = new TreeNode(100);
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
            int expected = 98;
            int actual1 = Solution.getSuccessor(a, 97).val;
            assertEquals(expected, actual1);
            int actual2 = Solution.getSuccessor_Editorial(a, 97).val;
            assertEquals(expected, actual2);
        });
    }

    @Test
    public void TrivialCase2() {        
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 97;
            int actual1 = Solution.getSuccessor(a, 96).val;
            assertEquals(expected, actual1);
            int actual2 = Solution.getSuccessor_Editorial(a, 96).val;
            assertEquals(expected, actual2);
        });
    }

    @Test
    public void TrivialCase3() {        
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 100;
            int actual1 = Solution.getSuccessor(a, 99).val;
            assertEquals(expected, actual1);
            int actual2 = Solution.getSuccessor_Editorial(a, 99).val;
            assertEquals(expected, actual2);
        });
    }

    @Test
    public void SpecialCase1() {        
        assertTimeout(Duration.ofMillis(500), () -> {
            TreeNode expected = null;
            TreeNode actual1 = Solution.getSuccessor(a, 102);
            assertEquals(expected, actual1);
            TreeNode actual2 = Solution.getSuccessor_Editorial(a, 102);
            assertEquals(expected, actual2);
        });
    }    
}