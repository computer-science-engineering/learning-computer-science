package Courses.Programming.Level3_Strings.Problems.StringSimulation.CountAndSay;

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
            String expected = "1211";
            String actual = Solution.countAndSay(4);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        assertTimeout(Duration.ofMillis(200), () -> {
            String expected = "11";
            String actual = Solution.countAndSay(2);
            assertEquals(expected, actual);
        });
    }
}