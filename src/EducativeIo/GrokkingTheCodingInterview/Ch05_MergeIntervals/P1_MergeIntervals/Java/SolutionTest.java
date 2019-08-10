package EducativeIo.GrokkingTheCodingInterview.Ch05_MergeIntervals.P1_MergeIntervals.Java;

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
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(2, 5));
        intervals.add(new Interval(7, 9));
        assertTimeout(Duration.ofMillis(500), () -> {
            List<List<Integer>> expected = Arrays.asList(Arrays.asList(1, 5), Arrays.asList(7, 9));
            List<List<Integer>> actual = new ArrayList<>();
            List<Interval> result = Solution.merge(intervals);
            for (Interval interval : result) {
                actual.add(Arrays.asList(interval.start, interval.end));
            }
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(2, 4));
        intervals.add(new Interval(5, 9));
        assertTimeout(Duration.ofMillis(500), () -> {
            List<List<Integer>> expected = Arrays.asList(Arrays.asList(2, 4), Arrays.asList(5, 9));
            List<List<Integer>> actual = new ArrayList<>();
            List<Interval> result = Solution.merge(intervals);
            for (Interval interval : result) {
                actual.add(Arrays.asList(interval.start, interval.end));
            }
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(3, 5));
        assertTimeout(Duration.ofMillis(500), () -> {
            List<List<Integer>> expected = Arrays.asList(Arrays.asList(1, 6));
            List<List<Integer>> actual = new ArrayList<>();
            List<Interval> result = Solution.merge(intervals);
            for (Interval interval : result) {
                actual.add(Arrays.asList(interval.start, interval.end));
            }
            assertEquals(expected, actual);
        });
    }
}
