package LeetCode.src.Explore.Interview.GoogleInterview.TreesAndGraphs.EvaluateDivision.Java;

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
        String[][] equations = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        assertTimeout(Duration.ofMillis(700), () -> {
            ArrayList<Double> expected = new ArrayList<Double>((Arrays.asList(6.0, 0.5, -1.0, 1.0, -1.0)));
            double[] result = Solution.calcEquation(equations, values, queries);
            ArrayList<Double> actual = new ArrayList<Double>();
            for (double item : result) {
                actual.add(item);
            }
            assertEquals(expected, actual);
        });
    }
}