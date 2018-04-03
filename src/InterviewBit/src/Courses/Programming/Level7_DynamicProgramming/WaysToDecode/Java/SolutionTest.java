package InterviewBit.src.Courses.Programming.Level7_DynamicProgramming.WaysToDecode.Java;

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
        String input = "12";
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 2;
            int actual = Solution.numDecodings(input);
            assertEquals(expected, actual);
            int actual_Editorial = solution.numDecodings_Editorial(input);
            assertEquals(expected, actual_Editorial);
        });
    }

    @Test
    public void TrivialCase2() {
        String input = "123";
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 3;
            int actual = Solution.numDecodings(input);
            assertEquals(expected, actual);
            int actual_Editorial = solution.numDecodings_Editorial(input);
            assertEquals(expected, actual_Editorial);
        });
    }

    @Test
    public void SpecialCase1() {
        String input = null;
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 0;
            int actual = Solution.numDecodings(input);
            assertEquals(expected, actual);
            int actual_Editorial = solution.numDecodings_Editorial(input);
            assertEquals(expected, actual_Editorial);
        });
    }
}