package InterviewBit.src.Courses.Programming.Level7_DynamicProgramming.TreeDp.MaxSumPathInBinaryTree.Java;

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
        int[] values = {
            1,
            2, 3};
        TreeNode A = TreeNode.fromArray(values);
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 6;
            int actual = Solution.maxPathSum(A);
            assertEquals(expected, actual);
        });
    }
}