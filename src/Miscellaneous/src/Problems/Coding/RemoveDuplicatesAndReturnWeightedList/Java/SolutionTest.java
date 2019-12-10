package Miscellaneous.src.Problems.Coding.RemoveDuplicatesAndReturnWeightedList.Java;

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
        int weight = 1;
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2, 1, 3, 2, 1));
        assertTimeout(Duration.ofMillis(500), () -> {
            ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 2, 3));;
            ArrayList<Integer> actual = Solution.removeDuplicates(weight, input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int weight = 2;
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2, 1, 3, 2, 1));
        assertTimeout(Duration.ofMillis(500), () -> {
            ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 3, 2));;
            ArrayList<Integer> actual = Solution.removeDuplicates(weight, input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        int weight = 3;
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2, 1, 3, 2, 1));
        assertTimeout(Duration.ofMillis(500), () -> {
            ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(3, 2, 1));;
            ArrayList<Integer> actual = Solution.removeDuplicates(weight, input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase4() {
        int weight = 3;
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2, 1, 3, 2, 1, 2));
        assertTimeout(Duration.ofMillis(500), () -> {
            ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(3, 1, 2));;
            ArrayList<Integer> actual = Solution.removeDuplicates(weight, input);
            assertEquals(expected, actual);
        });
    }
}