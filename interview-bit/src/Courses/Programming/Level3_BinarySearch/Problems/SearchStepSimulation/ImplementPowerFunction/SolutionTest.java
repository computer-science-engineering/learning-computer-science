package Courses.Programming.Level3_BinarySearch.Problems.SearchStepSimulation.ImplementPowerFunction;

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
        assertTimeout(Duration.ofMillis(200), () -> {
            int expected = 2;
            int actual = Solution.pow(2, 3, 3);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        assertTimeout(Duration.ofMillis(200), () -> {
            int expected = 19;
            int actual = Solution.pow(-1, 1, 20);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase1() {
        assertTimeout(Duration.ofMillis(200), () -> {
            int expected = 20805472;
            int actual = Solution.pow(71045970, 41535484, 64735492);
            assertEquals(expected, actual);
        });
    }
}