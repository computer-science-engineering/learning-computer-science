package LeetCode.src.Problems.P101_P200.P103_BinaryTreeZigzagLevelOrderTraversal.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

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
        int[] values = {
            5,
            4, 8,
            11, -1, 13, 4,
            7, 2, -1, -1, -1, -1, 5, 1};
        TreeNode a = TreeNode.fromArray(values);
        assertTimeout(Duration.ofMillis(1000), () -> {
            List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(5),
                Arrays.asList(8, 4),
                Arrays.asList(11, 13, 4),
                Arrays.asList(1, 5, 2, 7)
            );
            List<List<Integer>> actual = Solution.zigzagLevelOrder(a);
            assertEquals(expected, actual);
        });
    }
}