package InterviewBit.src.Courses.Programming.Level2_Math.Problems.NumberEncoding.RearrangeArray.Java;

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
        assertTimeout(Duration.ofMillis(700), () -> {
            String[] args = new String[0];
            assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(3, 2, 0, 1));
        assertTimeout(Duration.ofMillis(700), () -> {
            ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 0, 3, 2));;
            Solution.arrange(input);;
            assertEquals(expected, input);
        });
    }
}