package EducativeIo.Courses.GrokkingTheCodingInterview.Ch05_MergeIntervals.PC2_MaximumCpuLoad.Java;

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
        assertTimeout(Duration.ofMillis(700), () -> {
            String[] args = new String[0];
            assertAll(() -> Solution.main(args));
        });
    }

    @Test
    public void TrivialCase1() {
        List<Job> jobs = new ArrayList<Job>(
                Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 7;
            int actual = Solution.findMaxCPULoad(jobs);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        List<Job> jobs = new ArrayList<Job>(
                Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 15;
            int actual = Solution.findMaxCPULoad(jobs);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        List<Job> jobs = new ArrayList<Job>(
                Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 8;
            int actual = Solution.findMaxCPULoad(jobs);
            assertEquals(expected, actual);
        });
    }
}
