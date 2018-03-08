package InterviewBit.src.Courses.Programming.Level5_Backtracking.Problems.MathsAndBacktracking.KthPermutationSequence.Java;

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
        assertTimeout(Duration.ofMillis(500), () -> {
            String expected = "3142";
            String actual = Solution.getPermutation(4, 14);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        assertTimeout(Duration.ofMillis(500), () -> {
            String expected = "12";
            String actual = Solution.getPermutation(2, 1);
            assertEquals(expected, actual);
        });
    }
}