package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.TreeSearch.LeastCommonAncestor.Java;

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
        assertTimeout(Duration.ofMillis(500), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        int[] values = {
            3,
            5, 1,
            6, 2, 0, 8 ,
            -1, -1, 7, 4, -1, -1, -1, -1};
        TreeNode A = TreeNode.fromArray(values);
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected1 = -1;
            int actual1 = Solution.lca(A, 5, 50);
            assertEquals(expected1, actual1);
            int expected2 = 5;
            int actual2 = Solution.lca(A, 5, 4);
            assertEquals(expected2, actual2);
        });
    }
}