package InterviewBit.src.Courses.Programming.Level2_Arrays.Primers.Array_2D.Java;

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
        ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
        input.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4)));
        input.add(new ArrayList<Integer>(Arrays.asList(5, 6, 7, 8)));
        input.add(new ArrayList<Integer>(Arrays.asList(9, 10, 11, 12)));
        assertTimeout(Duration.ofMillis(500), () -> {
            ArrayList<ArrayList<Integer>> expected = new ArrayList<ArrayList<Integer>>();
            expected.add(new ArrayList<Integer>(Arrays.asList(4, 3, 2, 1)));
            expected.add(new ArrayList<Integer>(Arrays.asList(8, 7, 6, 5)));
            expected.add(new ArrayList<Integer>(Arrays.asList(12, 11, 10, 9)));
            ArrayList<ArrayList<Integer>> actual = Solution.performOps(input);
            assertEquals(expected, actual);
        });
    }
}