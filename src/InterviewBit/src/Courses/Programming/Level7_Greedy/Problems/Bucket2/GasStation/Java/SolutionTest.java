package InterviewBit.src.Courses.Programming.Level7_Greedy.Problems.Bucket2.GasStation.Java;

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
        assertTimeout(Duration.ofMillis(700), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        int[] A = {1, 2};
        int[] B = {2, 1};
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 1;
            int actual1 = Solution.canCompleteCircuit1(A, B);
            assertEquals(expected, actual1);
            int actual2 = Solution.canCompleteCircuit2(A, B);
            assertEquals(expected, actual2);
            int actual_Editorial = Solution.canCompleteCircuit_Editorial(A, B);
            assertEquals(expected, actual_Editorial);
        });
    }
}