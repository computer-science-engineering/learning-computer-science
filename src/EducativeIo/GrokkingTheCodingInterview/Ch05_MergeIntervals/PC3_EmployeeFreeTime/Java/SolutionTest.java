package EducativeIo.GrokkingTheCodingInterview.Ch05_MergeIntervals.PC3_EmployeeFreeTime.Java;

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
        List<List<Interval>> schedule = new ArrayList<>();
        schedule.add(
                new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        schedule.add(
                new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        assertTimeout(Duration.ofMillis(500), () -> {
            List<Integer> expected = Arrays.asList(3, 5);
            List<Integer> actual = new ArrayList<>();
            List<Interval> result = Solution.findEmployeeFreeTime(schedule);
            for (Interval interval : result) {
                actual.add(interval.start);
                actual.add(interval.end);
            }
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        List<List<Interval>> schedule = new ArrayList<>();
        schedule.add(
                new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
        schedule.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        schedule.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
        assertTimeout(Duration.ofMillis(500), () -> {
            List<Integer> expected = Arrays.asList(4, 6, 8, 9);
            List<Integer> actual = new ArrayList<>();
            List<Interval> result = Solution.findEmployeeFreeTime(schedule);
            for (Interval interval : result) {
                actual.add(interval.start);
                actual.add(interval.end);
            }
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        List<List<Interval>> schedule = new ArrayList<>();
        schedule.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3))));
        schedule.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        schedule.add(
                new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
        assertTimeout(Duration.ofMillis(500), () -> {
            List<Integer> expected = Arrays.asList(5, 7);
            List<Integer> actual = new ArrayList<>();
            List<Interval> result = Solution.findEmployeeFreeTime(schedule);
            for (Interval interval : result) {
                actual.add(interval.start);
                actual.add(interval.end);
            }
            assertEquals(expected, actual);
        });
    }
}
