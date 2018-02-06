package InterviewBit.src.Courses.Programming.Level2_Math.Examples.AllFactors.Java;

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
    public void TrivialCase1() {
        int input = 10;
        assertTimeout(Duration.ofMillis(500), () -> {
            ArrayList<Integer> actual = Solution.allFactors(input);
            ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 2, 5, 10));
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int input = 85463;
        assertTimeout(Duration.ofMillis(500), () -> {
            ArrayList<Integer> actual = Solution.allFactors(input);
            ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 7, 29, 203, 421, 2947, 12209,85463));
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase1() {
        int input = 38808;
        assertTimeout(Duration.ofMillis(500), () -> {
            ArrayList<Integer> actual = Solution.allFactors(input);
            ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 6, 7, 8, 9, 11, 12, 14, 18, 21, 22, 24, 28, 33, 36, 42, 44, 49, 56, 63, 66, 72, 77, 84, 88, 98, 99, 126, 132, 147, 154, 168, 196, 198, 231, 252, 264, 294, 308, 392, 396, 441, 462, 504, 539, 588, 616, 693, 792, 882, 924, 1078, 1176, 1386, 1617, 1764, 1848, 2156, 2772, 3234, 3528, 4312, 4851, 5544, 6468, 9702, 12936, 19404, 38808));
            assertEquals(expected, actual);
        });
    }
}