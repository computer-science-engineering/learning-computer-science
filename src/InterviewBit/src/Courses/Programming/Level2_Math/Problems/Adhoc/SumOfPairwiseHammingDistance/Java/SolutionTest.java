package InterviewBit.src.Courses.Programming.Level2_Math.Problems.Adhoc.SumOfPairwiseHammingDistance.Java;

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
        assertTimeout(Duration.ofMillis(500), () -> {
            String[] args = new String[0];
            assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        int[] input = {2, 4, 6};
        assertTimeout(Duration.ofMillis(500), () -> {
            int actual = Solution.hammingDistance(input);
            int expected = 8;
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] input = {1, 3, 5};
        assertTimeout(Duration.ofMillis(500), () -> {
            int actual = Solution.hammingDistance(input);
            int expected = 8;
            assertEquals(expected, actual);
        });
    }
}