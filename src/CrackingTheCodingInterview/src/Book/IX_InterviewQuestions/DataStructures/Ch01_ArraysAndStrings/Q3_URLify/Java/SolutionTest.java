package CrackingTheCodingInterview.src.Book.IX_InterviewQuestions.DataStructures.Ch01_ArraysAndStrings.Q3_URLify.Java;

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
        String input = "Mr John Smith    ";
        assertTimeout(Duration.ofMillis(500), () -> {
            String expected = "\"Mr%20John%20Smith\"";
            String actual = Solution.Urlify(input);
            assertEquals(expected, actual);
        });
    }
}