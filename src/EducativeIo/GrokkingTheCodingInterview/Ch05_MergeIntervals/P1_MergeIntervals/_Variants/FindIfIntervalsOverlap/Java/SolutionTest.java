package EducativeIo.GrokkingTheCodingInterview.Ch05_MergeIntervals.P1_MergeIntervals._Variants.FindIfIntervalsOverlap.Java;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import java.util.ArrayList;
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
            boolean expected = true;
            boolean actual = Solution.doesOverlap(intervals);
            assertEquals(expected, actual);
        });
    }
}
