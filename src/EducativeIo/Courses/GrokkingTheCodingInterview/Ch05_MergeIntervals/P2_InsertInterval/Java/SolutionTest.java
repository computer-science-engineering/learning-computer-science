package EducativeIo.Courses.GrokkingTheCodingInterview.Ch05_MergeIntervals.P2_InsertInterval.Java;

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
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(5, 7));
        intervals.add(new Interval(8, 12));
        Interval newInterval = new Interval(4, 6);
        assertTimeout(Duration.ofMillis(500), () -> {
            List<List<Integer>> expected =
                    Arrays.asList(Arrays.asList(1, 3), Arrays.asList(4, 7), Arrays.asList(8, 12));
            List<List<Integer>> actual = new ArrayList<>();
            List<Interval> result = Solution.insert(intervals, newInterval);
            for (Interval interval : result) {
                actual.add(Arrays.asList(interval.start, interval.end));
            }
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(5, 7));
        intervals.add(new Interval(8, 12));
        Interval newInterval = new Interval(4, 10);
        assertTimeout(Duration.ofMillis(500), () -> {
            List<List<Integer>> expected = Arrays.asList(Arrays.asList(1, 3), Arrays.asList(4, 12));
            List<List<Integer>> actual = new ArrayList<>();
            List<Interval> result = Solution.insert(intervals, newInterval);
            for (Interval interval : result) {
                actual.add(Arrays.asList(interval.start, interval.end));
            }
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(2, 3));
        intervals.add(new Interval(5, 7));
        Interval newInterval = new Interval(1, 4);
        assertTimeout(Duration.ofMillis(500), () -> {
            List<List<Integer>> expected = Arrays.asList(Arrays.asList(1, 4), Arrays.asList(5, 7));
            List<List<Integer>> actual = new ArrayList<>();
            List<Interval> result = Solution.insert(intervals, newInterval);
            for (Interval interval : result) {
                actual.add(Arrays.asList(interval.start, interval.end));
            }
            assertEquals(expected, actual);
        });
    }
}
