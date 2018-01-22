package InterviewBit.src.Courses.Programming.Level3_TwoPointers.Problems.TwoPointer.MinimizeAbsoluteDifference.Java;

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
    public void TrivialCase1() {
        int[] A = {1, 4, 5, 8, 10}; 
        int[] B = {6, 9, 15};
        int[] C = {2, 3, 6, 6};
        assertTimeout(Duration.ofMillis(200), () -> {
            int expected = 1;
            int actual = Solution.solve(A, B, C);
            assertEquals(expected, actual);
        });
    }
}