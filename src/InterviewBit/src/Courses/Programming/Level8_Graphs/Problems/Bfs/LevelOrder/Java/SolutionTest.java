package InterviewBit.src.Courses.Programming.Level8_Graphs.Problems.Bfs.LevelOrder.Java;

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
        assertTimeout(Duration.ofMillis(500), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        int[] values = {
            3,
            9, 20,
            -1, -1, 15, 7};
        TreeNode A = TreeNode.fromArray(values);
        assertTimeout(Duration.ofMillis(500), () -> {
            ArrayList<ArrayList<Integer>> expected = new ArrayList<ArrayList<Integer>>();
            expected.add(new ArrayList<Integer>(Arrays.asList(3)));
            expected.add(new ArrayList<Integer>(Arrays.asList(9, 20)));
            expected.add(new ArrayList<Integer>(Arrays.asList(15, 7)));
            ArrayList<ArrayList<Integer>> actual = Solution.levelOrder(A);
            assertEquals(expected, actual);
            ArrayList<ArrayList<Integer>> actual_Editorial = Solution.levelOrder_Editorial(A);
            assertEquals(expected, actual_Editorial);
        });
    }
}