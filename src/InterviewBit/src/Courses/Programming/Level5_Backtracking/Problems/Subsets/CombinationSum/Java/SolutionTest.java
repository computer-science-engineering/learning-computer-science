package InterviewBit.src.Courses.Programming.Level5_Backtracking.Problems.Subsets.CombinationSum.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.*;
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
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(2,3,6,7));;
        assertTimeout(Duration.ofMillis(700), () -> {
            ArrayList<ArrayList<Integer>> expected = new  ArrayList<ArrayList<Integer>>();
            expected.add(new ArrayList<Integer>(Arrays.asList(2,2,3)));
            expected.add(new ArrayList<Integer>(Arrays.asList(7)));
            ArrayList<ArrayList<Integer>> actual = Solution.combinationSum(input, 7);
            assertEquals(expected, actual);
        });
    }
}