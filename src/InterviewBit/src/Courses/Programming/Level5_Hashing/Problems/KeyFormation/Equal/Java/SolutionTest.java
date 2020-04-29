package InterviewBit.src.Courses.Programming.Level5_Hashing.Problems.KeyFormation.Equal.Java;

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
        assertTimeout(Duration.ofMillis(1000), () -> {
            String[] args = new String[0];
            assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(3, 4, 7, 1, 2, 9, 8));
        assertTimeout(Duration.ofMillis(1000), () -> {
            ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(0, 2, 3, 5));
            ArrayList<Integer> actual = Solution.equal(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase1() {
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1));
        assertTimeout(Duration.ofMillis(1000), () -> {
            ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3));
            ArrayList<Integer> actual = Solution.equal(input);
            assertEquals(expected, actual);
        });
    }
}