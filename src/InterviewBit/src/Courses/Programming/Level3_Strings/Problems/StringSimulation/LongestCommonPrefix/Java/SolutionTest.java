package InterviewBit.src.Courses.Programming.Level3_Strings.Problems.StringSimulation.LongestCommonPrefix.Java;

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
        String[] input = new String[] {"abcdefgh", "aefghijk", "abcefgh"};  
        assertTimeout(Duration.ofMillis(500), () -> {
            String expected = "a";
            String actual = Solution.longestCommonPrefix(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase1() {           
        String[] input = new String[] {"ABCD"};
        assertTimeout(Duration.ofMillis(500), () -> {
            String expected = "ABCD";
            String actual = Solution.longestCommonPrefix(input);
            assertEquals(expected, actual);
        });
    }
}