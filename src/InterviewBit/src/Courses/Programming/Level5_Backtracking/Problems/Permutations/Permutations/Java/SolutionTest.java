package InterviewBit.src.Courses.Programming.Level5_Backtracking.Problems.Permutations.Permutations.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
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
        assertTimeout(Duration.ofMillis(1000), () -> {
            String[] args = new String[0];
            assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,2,3));
        assertTimeout(Duration.ofMillis(1000), () -> {
            ArrayList<ArrayList<Integer>> expected = new  ArrayList<ArrayList<Integer>>();
            expected.add(new ArrayList<Integer>(Arrays.asList(1,2,3)));
            expected.add(new ArrayList<Integer>(Arrays.asList(1,3,2)));
            expected.add(new ArrayList<Integer>(Arrays.asList(2,1,3)));
            expected.add(new ArrayList<Integer>(Arrays.asList(2,3,1)));
            expected.add(new ArrayList<Integer>(Arrays.asList(3,1,2)));
            expected.add(new ArrayList<Integer>(Arrays.asList(3,2,1)));
            ArrayList<ArrayList<Integer>> actual = Solution.permute(A);
            assertEquals(expected, actual);
        });
    }
}