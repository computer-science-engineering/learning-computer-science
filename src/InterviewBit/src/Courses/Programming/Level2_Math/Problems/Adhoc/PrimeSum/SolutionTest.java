package InterviewBit.src.Courses.Programming.Level2_Math.Problems.Adhoc.PrimeSum;

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
    public void TrivialCase1() {
        int input = 10;
        assertTimeout(Duration.ofMillis(200), () -> {
            ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(3, 7));
            ArrayList<Integer> actual = Solution.primeSum(input);
            assertEquals(expected, actual);
        });
    }
}