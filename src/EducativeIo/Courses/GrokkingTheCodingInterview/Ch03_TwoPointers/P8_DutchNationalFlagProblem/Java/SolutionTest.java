package EducativeIo.Courses.GrokkingTheCodingInterview.Ch03_TwoPointers.P8_DutchNationalFlagProblem.Java;

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
        int[] arr = new int[] {1, 0, 2, 1, 0};
        assertTimeout(Duration.ofMillis(500), () -> {
            int[] expected = new int[] {0, 0, 1, 1, 2};
            Solution.sort(arr);
            assertArrayEquals(expected, arr);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] arr = new int[] {2, 2, 0, 1, 2, 0};
        assertTimeout(Duration.ofMillis(500), () -> {
            int[] expected = new int[] {0, 0, 1, 2, 2, 2};
            Solution.sort(arr);
            assertArrayEquals(expected, arr);
        });
    }
}
