package LeetCode.src.Explore.Interview.GoogleInterview.InterviewProcess.RepeatedStringMatch.Java;

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
        String A = "abcd";
        String B = "cdabcdab";
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 3;
            int actual = Solution.repeatedStringMatch(A, B);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String A = "abcd";
        String B = "cdabcdaeeb";
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = -1;
            int actual = Solution.repeatedStringMatch(A, B);
            assertEquals(expected, actual);
        });
    }
}