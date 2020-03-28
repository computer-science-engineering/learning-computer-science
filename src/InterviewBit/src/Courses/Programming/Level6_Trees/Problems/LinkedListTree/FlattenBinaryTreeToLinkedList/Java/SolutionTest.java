package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.LinkedListTree.FlattenBinaryTreeToLinkedList.Java;

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
        assertTimeout(Duration.ofMillis(700), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        int[] values = {
            1,
            2, 5,
            3, 4, -1, 6};
        TreeNode a = TreeNode.fromArray(values);
        assertTimeout(Duration.ofMillis(700), () -> {
            ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
            TreeNode result = Solution.flatten(a);
            ArrayList<Integer> actual = Solution.levelOrder(result);
            assertEquals(expected, actual);
        });
    }
}