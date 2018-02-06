package InterviewBit.src.Courses.Programming.Level2_Math.Problems.Combinatorics.GridUniquePaths.Java;

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
            int expected = 2;
            int actual = Solution.uniquePaths(2, 2);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 6;
            int actual = Solution.uniquePaths(3, 3);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 20;
            int actual = Solution.uniquePaths(4, 4);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase4() {
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 319770;
            int actual = Solution.uniquePaths(15, 9);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase5() {
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 10400600;
            int actual = Solution.uniquePaths(14, 14);
            assertEquals(expected, actual);
        });
    }
}