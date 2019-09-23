package EducativeIo.Courses.GrokkingTheCodingInterview.Ch10_TwoHeaps.PC1_NextInterval.Java;

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
        Interval[] intervals =
                new Interval[] {new Interval(2, 3), new Interval(3, 4), new Interval(5, 6)};
        assertTimeout(Duration.ofMillis(500), () -> {
            int[] expected = new int[] {1, 2, -1};
            int[] actual = Solution.findNextInterval(intervals);
            assertArrayEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        Interval[] intervals =
                new Interval[] {new Interval(3, 4), new Interval(1, 5), new Interval(4, 6)};
        assertTimeout(Duration.ofMillis(500), () -> {
            int[] expected = new int[] {2, -1, -1};
            int[] actual = Solution.findNextInterval(intervals);
            assertArrayEquals(expected, actual);
        });
    }
}
