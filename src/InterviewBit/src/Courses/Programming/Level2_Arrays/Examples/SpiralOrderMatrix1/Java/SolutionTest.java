package InterviewBit.src.Courses.Programming.Level2_Arrays.Examples.SpiralOrderMatrix1.Java;

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
        assertTimeout(Duration.ofMillis(500), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        List<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
        input.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        input.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
        input.add(new ArrayList<Integer>(Arrays.asList(5, 6)));
        assertTimeout(Duration.ofMillis(500), () -> {
            ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 6, 5, 3));
            ArrayList<Integer> actual = Solution.spiralOrder(input);
            assertEquals(expected, actual);
        });
    }
}