package EducativeIo.GrokkingTheCodingInterview.Ch05_MergeIntervals.P4_ConflictingAppointments._Variants.P1_FindAllConflictingAppointments.Java;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.graalvm.compiler.lir.alloc.lsra.Interval;
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
        Interval[] intervals = {new Interval(4, 5), new Interval(2, 3), new Interval(3, 6),
                new Interval(5, 7), new Interval(7, 8)};
        assertTimeout(Duration.ofMillis(500), () -> {
            List<List<Integer>> expected =
                    Arrays.asList(Arrays.asList(3, 6, 4, 5), Arrays.asList(3, 6, 5, 7));
            List<List<Interval>> result = Solution.conflictingAppointments(intervals);
            List<List<Integer>> actual = new ArrayList<>();
            for (List<Interval> item : result) {
                List<Integer> temp = new ArrayList<>();
                for (Interval interval : item) {
                    temp.add(interval.start);
                    temp.add(interval.end);
                }
                actual.add(temp);
            }
            assertEquals(expected, actual);
        });
    }
}
