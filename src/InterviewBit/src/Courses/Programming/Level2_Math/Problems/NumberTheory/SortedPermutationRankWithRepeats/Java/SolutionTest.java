package InterviewBit.src.Courses.Programming.Level2_Math.Problems.NumberTheory.SortedPermutationRankWithRepeats.Java;

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
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 502900;
            int actual = Solution.findRank("asasdsdsadasdadsadasdsa");
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 356974;
            int actual = Solution.findRank("IhSKbdvuqfmGHh");
            assertEquals(expected, actual);
        });
    }
}