package LeetCode.src.Explore.Interview.GoogleInterview.InterviewProcess.LongestUnivaluePath.Java;

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
            5,
            4, 5,
            1, 1, -1, 5 };
        TreeNode A = TreeNode.fromArray(values);
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 2;
            int actual = Solution.longestUnivaluePath(A);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] values = {
            1,
            4, 5,
            4, 4, -1, 5 };
        TreeNode A = TreeNode.fromArray(values);
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 2;
            int actual = Solution.longestUnivaluePath(A);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase1() {
        int[] values = {
            1};
        TreeNode A = TreeNode.fromArray(values);
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 0;
            int actual = Solution.longestUnivaluePath(A);
            assertEquals(expected, actual);
        });
    }
}