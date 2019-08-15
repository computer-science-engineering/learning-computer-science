package EducativeIo.GrokkingTheCodingInterview.Ch05_MergeIntervals.PC1_MinimumMeetingRooms._Variants.P1_MaximumNumberOfIntervalsOverlapPoint.Java;

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
        assertTimeout(Duration.ofMillis(500), () -> {
            String[] args = new String[0];
            assertAll(() -> Solution.main(args));
        });
    }

    @Test
    public void TrivialCase1() {
        Interval intervals[] = new Interval[] {new Interval(1, 4), new Interval(2, 5),
                new Interval(9, 12), new Interval(5, 9), new Interval(5, 12)};
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 5;
            int actual = Solution.findMaxOverlapPoint(intervals);
            assertEquals(expected, actual);
        });
    }
}
