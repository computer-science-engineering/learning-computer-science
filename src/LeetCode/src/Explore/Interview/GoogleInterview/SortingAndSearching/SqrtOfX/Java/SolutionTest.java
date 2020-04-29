package LeetCode.src.Explore.Interview.GoogleInterview.SortingAndSearching.SqrtOfX.Java;

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
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 3;
            int actual = Solution.mySqrt(9);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 3;
            int actual = Solution.mySqrt(11);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase1() {
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 30506;
            int actual = Solution.mySqrt(930675566);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase2() {
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 1;
            int actual = Solution.mySqrt(1);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase3() {
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 13003;
            int actual = Solution.mySqrt(169078009);
            assertEquals(expected, actual);
        });
    }
}