package EducativeIo.Courses.GrokkingTheCodingInterview.Ch10_TwoHeaps.P3_MaximizeCapital.Java;

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
        assertTimeout(Duration.ofMillis(1000), () -> {
            String[] args = new String[0];
            assertAll(() -> Solution.main(args));
        });
    }

    @Test
    public void TrivialCase1() {
        int[] capital = new int[] {0, 1, 2};
        int[] profits = new int[] {1, 2, 3};
        int numberOfProjects = 2;
        int initialCapital = 1;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 6;
            int actual =
                    Solution.findMaximumCapital(capital, profits, numberOfProjects, initialCapital);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] capital = new int[] {0, 1, 2, 3};
        int[] profits = new int[] {1, 2, 3, 5};
        int numberOfProjects = 3;
        int initialCapital = 0;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 8;
            int actual =
                    Solution.findMaximumCapital(capital, profits, numberOfProjects, initialCapital);
            assertEquals(expected, actual);
        });
    }
}
