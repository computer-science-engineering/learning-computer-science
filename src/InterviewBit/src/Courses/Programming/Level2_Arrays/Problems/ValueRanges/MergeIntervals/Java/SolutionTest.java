package InterviewBit.src.Courses.Programming.Level2_Arrays.Problems.ValueRanges.MergeIntervals.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.*;
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
        ArrayList<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(6, 9));
        Interval newInterval = new Interval(2, 5);
        assertTimeout(Duration.ofMillis(500), () -> {
            ArrayList<Interval> actual = Solution.insert(input, newInterval);
            List<Interval> expected = Arrays.asList(new Interval(1, 5), new Interval(6, 9));
            int index = 0;
            for (Interval interval : actual) {
                assertEquals(interval.start, expected.get(index).start);
                assertEquals(interval.end, expected.get(index).end);
                index++;
            }
        });
    }

    @Test
    public void TrivialCase2() {
        ArrayList<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 2));
        input.add(new Interval(3, 5));
        input.add(new Interval(6, 7));
        input.add(new Interval(8, 10));
        input.add(new Interval(12, 16));
        Interval newInterval = new Interval(4, 9);
        assertTimeout(Duration.ofMillis(500), () -> {
            ArrayList<Interval> actual = Solution.insert(input, newInterval);
            List<Interval> expected = Arrays.asList(new Interval(1, 2), new Interval(3, 10), new Interval(12, 16));
            int index = 0;
            for (Interval interval : actual) {
                assertEquals(interval.start, expected.get(index).start);
                assertEquals(interval.end, expected.get(index).end);
                index++;
            }
        });
    }

    @Test
    public void PreceedingInterval() {
        ArrayList<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(3, 6));
        input.add(new Interval(8, 10));
        Interval newInterval = new Interval(1, 2);
        assertTimeout(Duration.ofMillis(500), () -> {
            ArrayList<Interval> actual = Solution.insert(input, newInterval);
            List<Interval> expected = Arrays.asList(new Interval(1, 2), new Interval(3, 6), new Interval(8, 10));
            int index = 0;
            for (Interval interval : actual) {
                assertEquals(interval.start, expected.get(index).start);
                assertEquals(interval.end, expected.get(index).end);
                index++;
            }
        });
    }

    @Test
    public void SucceedingInterval() {
        ArrayList<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 2));
        input.add(new Interval(3, 6));
        Interval newInterval = new Interval(8, 10);
        assertTimeout(Duration.ofMillis(500), () -> {
            ArrayList<Interval> actual = Solution.insert(input, newInterval);
            List<Interval> expected = Arrays.asList(new Interval(1, 2), new Interval(3, 6), new Interval(8, 10));
            int index = 0;
            for (Interval interval : actual) {
                assertEquals(interval.start, expected.get(index).start);
                assertEquals(interval.end, expected.get(index).end);
                index++;
            }
        });
    }

    @Test
    public void EncompassingInterval() {
        ArrayList<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 6));
        Interval newInterval = new Interval(1, 10);
        assertTimeout(Duration.ofMillis(500), () -> {
            ArrayList<Interval> actual = Solution.insert(input, newInterval);
            List<Interval> expected = Arrays.asList(new Interval(1, 10));
            int index = 0;
            for (Interval interval : actual) {
                assertEquals(interval.start, expected.get(index).start);
                assertEquals(interval.end, expected.get(index).end);
                index++;
            }
        });
    }
}