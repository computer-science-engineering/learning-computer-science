package LeetCode.src.Problems.P101_P200.P173_BinarySearchTreeIterator.Java;

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
            4, 8,
            11, -1, 13, 4,
            7, 2, -1, -1, -1, -1, 5, 1};            
        TreeNode root = TreeNode.fromArray(values);
        assertTimeout(Duration.ofMillis(500), () -> {
            int[] expected = {7, 11, 2, 4, 5, 13, 8, 5, 4, 1};
            int[] actual  = new int[expected.length];
            BstIterator i = new BstIterator(root);
            int j = 0;
            while(Solution.hasNext(i)) {
                actual[j++] = Solution.next(i);
            }
            assertArrayEquals(expected, actual);
        });
    }
}