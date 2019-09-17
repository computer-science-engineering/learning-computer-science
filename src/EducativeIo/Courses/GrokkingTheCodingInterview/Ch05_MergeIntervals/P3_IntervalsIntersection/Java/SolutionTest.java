package EducativeIo.Courses.GrokkingTheCodingInterview.Ch05_MergeIntervals.P3_IntervalsIntersection.Java;

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
        Interval[] arr1 =
                new Interval[] {new Interval(1, 3), new Interval(5, 6), new Interval(7, 9)};
        Interval[] arr2 = new Interval[] {new Interval(2, 3), new Interval(5, 7)};
        assertTimeout(Duration.ofMillis(500), () -> {
            List<List<Integer>> expected =
                    Arrays.asList(Arrays.asList(2, 3), Arrays.asList(5, 6), Arrays.asList(7, 7));
            List<List<Integer>> actual = new ArrayList<>();
            Interval[] result = Solution.merge(arr1, arr2);
            for (Interval interval : result) {
                actual.add(Arrays.asList(interval.start, interval.end));
            }
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        Interval[] arr1 =
                new Interval[] {new Interval(1, 3), new Interval(5, 7), new Interval(9, 12)};
        Interval[] arr2 = new Interval[] {new Interval(5, 10)};
        assertTimeout(Duration.ofMillis(500), () -> {
            List<List<Integer>> expected = Arrays.asList(Arrays.asList(5, 7), Arrays.asList(9, 10));
            List<List<Integer>> actual = new ArrayList<>();
            Interval[] result = Solution.merge(arr1, arr2);
            for (Interval interval : result) {
                actual.add(Arrays.asList(interval.start, interval.end));
            }
            assertEquals(expected, actual);
        });
    }
}
