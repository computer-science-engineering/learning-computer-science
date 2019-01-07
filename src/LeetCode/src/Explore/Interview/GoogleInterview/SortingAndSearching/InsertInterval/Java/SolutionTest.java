package LeetCode.src.Explore.Interview.GoogleInterview.SortingAndSearching.InsertInterval.Java;

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
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(6, 7));        
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(12, 16));
        Interval newInterval = new Interval(4, 8);
        assertTimeout(Duration.ofMillis(500), () -> {
            List<Integer> expected = Arrays.asList(1,2,3,10,12,16);
            List<Interval> result = Solution.insert(intervals, newInterval);
            List<Integer> actual = new ArrayList<>();
            for(Interval item : result) {
                actual.add(item.start);
                actual.add(item.end);
            }
            assertEquals(expected, actual);
        });
    }
}