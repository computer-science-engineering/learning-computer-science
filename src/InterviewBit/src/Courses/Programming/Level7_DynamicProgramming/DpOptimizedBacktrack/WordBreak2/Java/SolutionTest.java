package InterviewBit.src.Courses.Programming.Level7_DynamicProgramming.DpOptimizedBacktrack.WordBreak2.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

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
        String A = "catsanddog";
        ArrayList<String> B = new ArrayList<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        assertTimeout(Duration.ofMillis(500), () -> {
            ArrayList<String> expected = new ArrayList<String>(Arrays.asList("cat sand dog", "cats and dog"));
            ArrayList<String> actual = Solution.wordBreak(A, B);
            assertEquals(expected, actual);
        });
    }
}