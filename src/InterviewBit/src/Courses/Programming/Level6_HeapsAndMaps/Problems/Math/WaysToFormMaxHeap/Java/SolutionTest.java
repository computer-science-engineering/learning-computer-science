package InterviewBit.src.Courses.Programming.Level6_HeapsAndMaps.Problems.Math.WaysToFormMaxHeap.Java;

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
        int input = 4;
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 3;
            int actual = Solution.solve(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int input = 20;
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 258365767;
            int actual = Solution.solve(input);
            assertEquals(expected, actual);
        });
    }
}