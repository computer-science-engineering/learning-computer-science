package InterviewBit.src.Courses.Programming.Level3_Strings.Problems.Words.ReverseTheString.Java;

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
        String input = "the sky is blue";
        assertTimeout(Duration.ofMillis(500), () -> {
            String expected = "blue is sky the";
            String actual = Solution.reverseWords(input);
            assertEquals(expected, actual);
        });
    }
}