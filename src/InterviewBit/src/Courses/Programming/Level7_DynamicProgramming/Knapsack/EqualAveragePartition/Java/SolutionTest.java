package InterviewBit.src.Courses.Programming.Level7_DynamicProgramming.Knapsack.EqualAveragePartition.Java;

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
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 7, 15, 29, 11, 9));
        assertTimeout(Duration.ofMillis(700), () -> {
            ArrayList<ArrayList<Integer>> expected = new ArrayList<ArrayList<Integer>>();
            expected.add(new ArrayList<Integer>(Arrays.asList(9, 15)));
            expected.add(new ArrayList<Integer>(Arrays.asList(1, 7, 11, 29)));
            ArrayList<ArrayList<Integer>> actual = Solution.avgSet(A);
            assertEquals(expected, actual);
            ArrayList<ArrayList<Integer>> actual_Editorial = solution.avgSet_Editorial(A);
            assertEquals(expected, actual_Editorial);
        });
    }
}