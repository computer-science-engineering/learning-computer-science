package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.BstTraversal.KthSmallestElementInTree.Java;

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
        assertTimeout(Duration.ofMillis(700), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        TreeNode A = new TreeNode(2);
        TreeNode B1 = new TreeNode(1);
        TreeNode B2 = new TreeNode(3);
        A.left = B1;
        A.right = B2;
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 2;
            int actual = Solution.kthSmallest(A, 2);
            assertEquals(expected, actual);
        });
    }
}