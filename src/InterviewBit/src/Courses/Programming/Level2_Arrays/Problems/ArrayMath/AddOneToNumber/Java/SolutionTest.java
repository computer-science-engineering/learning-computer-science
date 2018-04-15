package InterviewBit.src.Courses.Programming.Level2_Arrays.Problems.ArrayMath.AddOneToNumber.Java;

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
        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        assertTimeout(Duration.ofMillis(500), () -> {
            ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 2, 4));
            ArrayList<Integer> actual = Solution.plusOne(a);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(1, 2, 9));
        assertTimeout(Duration.ofMillis(500), () -> {
            ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 3, 0));
            ArrayList<Integer> actual = Solution.plusOne(a);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase1() {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(0);
        a.add(0);
        assertTimeout(Duration.ofMillis(500), () -> {
            ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1));
            ArrayList<Integer> actual = Solution.plusOne(a);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase2() {
        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(9, 9, 9, 9));
        assertTimeout(Duration.ofMillis(500), () -> {
            ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 0, 0, 0, 0));
            ArrayList<Integer> actual = Solution.plusOne(a);
            assertEquals(expected, actual);
        });
    }
}