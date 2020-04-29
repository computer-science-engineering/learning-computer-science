package LeetCode.src.Explore.Interview.GoogleInterview.DynamicProgramming.EditDistance.Java;

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
        assertTimeout(Duration.ofMillis(1000), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        String A = "Anshuman";
        String B = "Antihuman";
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 2;
            int actual = Solution.minDistance(A, B);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String A = "horse";
        String B = "ros";
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 3;
            int actual = Solution.minDistance(A, B);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        String A = "intention";
        String B = "execution";
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 5;
            int actual = Solution.minDistance(A, B);
            assertEquals(expected, actual);
        });
    }
}