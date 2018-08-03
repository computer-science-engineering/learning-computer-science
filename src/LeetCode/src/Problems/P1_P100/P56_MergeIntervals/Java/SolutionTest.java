package LeetCode.src.Problems.P1_P100.P56_MergeIntervals.Java;

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
        List<Interval> intervals = Arrays.asList(
            new Interval(1,3),
            new Interval(2,6),
            new Interval(8,10),
            new Interval(15,18)
        );
        assertTimeout(Duration.ofMillis(500), () -> {
            List<Integer> expected = Arrays.asList(1, 6, 8, 10, 15, 18);
            List<Interval> result = Solution.merge(intervals);
            List<Interval> result_opt = Solution.merge_opt(intervals);
            List<Integer> actual = new ArrayList<>();
            List<Integer> actual_opt = new ArrayList<>();
            for (Interval interval : result) {
                actual.add(interval.start);
                actual.add(interval.end);
            }
            for (Interval interval : result_opt) {
                actual_opt.add(interval.start);
                actual_opt.add(interval.end);
            }
            assertEquals(expected, actual_opt);
        });
    }
}