package EducativeIo.GrokkingTheCodingInterview.Ch05_MergeIntervals.PC1_MinimumMeetingRooms._Variants.P2_MinimumNumberOfPlatformsForTrainStation.Java;

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
        Interval intervals[] = new Interval[] {new Interval(900, 910), new Interval(940, 1200),
                new Interval(950, 1120), new Interval(1100, 1130), new Interval(1500, 1900),
                new Interval(1800, 2000)};
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 3;
            int actual = Solution.findMinNumberOfPlatforms(intervals);
            assertEquals(expected, actual);
        });
    }
}
