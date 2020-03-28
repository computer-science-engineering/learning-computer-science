package InterviewBit.src.Courses.Programming.Level7_Greedy.Problems.Bucket4.Seats.Java;

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
        assertTimeout(Duration.ofMillis(700), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        String A = "....x..xx...x..";
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 5;
            int actual_BruteForce = Solution.seats_BruteForce(A);
            assertEquals(expected, actual_BruteForce);
            int actual1 = Solution.seats1(A);
            assertEquals(expected, actual1);
            int actual2 = Solution.seats2(A);
            assertEquals(expected, actual2);
            int actual_Editorial = Solution.seats_Editorial(A);
            assertEquals(expected, actual_Editorial);
        });
    }
}