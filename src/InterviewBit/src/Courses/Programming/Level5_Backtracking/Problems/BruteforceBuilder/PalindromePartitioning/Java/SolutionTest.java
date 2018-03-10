package InterviewBit.src.Courses.Programming.Level5_Backtracking.Problems.BruteForceBuilder.PalindromePartitioning.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.*;
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
        String input = "aab";
        assertTimeout(Duration.ofMillis(500), () -> {
            ArrayList<ArrayList<String>> expected = new ArrayList<ArrayList<String>>();
            expected.add(new ArrayList<String>(Arrays.asList("a","a","b")));
            expected.add(new ArrayList<String>(Arrays.asList("aa", "b")));
            ArrayList<ArrayList<String>> actual = Solution.partition(input);
            assertEquals(expected, actual);
        });
    }
}