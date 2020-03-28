package InterviewBit.src.Courses.Programming.Level5_Hashing.Problems.IncrementalHash.SubstringConcatenation.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        String A = "barfoothefoobarman";
        List<String> B = new ArrayList<String>(Arrays.asList("foo", "bar"));
        assertTimeout(Duration.ofMillis(700), () -> {
            ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(0, 9));
            ArrayList<Integer> actual1 = Solution.findSubstring(A, B);
            assertEquals(expected, actual1);
            ArrayList<Integer> actual2 = Solution.findSubstring_Editorial(A, B);
            assertEquals(expected, actual2);
        });
    }
}