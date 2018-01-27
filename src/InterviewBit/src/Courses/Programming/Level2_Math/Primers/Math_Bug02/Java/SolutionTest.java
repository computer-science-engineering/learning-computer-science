package InterviewBit.src.Courses.Programming.Level2_Math.Primers.Math_Bug02.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
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
        int input = 20;
        assertTimeout(Duration.ofMillis(200), () -> {
            ArrayList<ArrayList<Integer>> actual = Solution.squareSum(input);
            ArrayList<ArrayList<Integer>> expected = new ArrayList<ArrayList<Integer>>();
            expected.add(new ArrayList<Integer>() {private static final long serialVersionUID = 1L;

			{
                add(2);
                add(4);
            }});
            assertEquals(expected, actual);
        });
    }
}