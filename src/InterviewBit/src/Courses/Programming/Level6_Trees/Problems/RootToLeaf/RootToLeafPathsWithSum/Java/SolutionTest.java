package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.RootToLeaf.RootToLeafPathsWithSum.Java;

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
            5,
            4, 8,
            11, -1, 13, 4,
            7, 2, -1, -1, -1, -1, 5, 1};
        TreeNode a = TreeNode.fromArray(values);
        assertTimeout(Duration.ofMillis(500), () -> {
            ArrayList<ArrayList<Integer>> expected = new ArrayList<ArrayList<Integer>>();
            expected.add(new ArrayList<Integer>(Arrays.asList(5, 4, 11, 2)));
            expected.add(new ArrayList<Integer>(Arrays.asList(5, 8, 4, 5)));
            ArrayList<ArrayList<Integer>> actual = Solution.pathSum(a, 22);
            assertEquals(expected, actual);
        });
    }
}