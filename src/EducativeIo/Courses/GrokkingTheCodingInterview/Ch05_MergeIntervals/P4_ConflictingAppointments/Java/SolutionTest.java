package EducativeIo.Courses.GrokkingTheCodingInterview.Ch05_MergeIntervals.P4_ConflictingAppointments.Java;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
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
        Interval[] intervals = {new Interval(1, 4), new Interval(2, 5), new Interval(7, 9)};
        assertTimeout(Duration.ofMillis(700), () -> {
            boolean expected = false;
            boolean actual = Solution.canAttendAllAppointments(intervals);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        Interval[] intervals = {new Interval(6, 7), new Interval(2, 4), new Interval(8, 12)};
        assertTimeout(Duration.ofMillis(700), () -> {
            boolean expected = true;
            boolean actual = Solution.canAttendAllAppointments(intervals);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        Interval[] intervals = {new Interval(4, 5), new Interval(2, 3), new Interval(3, 6)};
        assertTimeout(Duration.ofMillis(700), () -> {
            boolean expected = false;
            boolean actual = Solution.canAttendAllAppointments(intervals);
            assertEquals(expected, actual);
        });
    }
}
