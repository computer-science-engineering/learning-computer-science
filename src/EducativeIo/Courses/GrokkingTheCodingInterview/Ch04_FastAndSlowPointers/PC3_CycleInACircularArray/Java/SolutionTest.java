package EducativeIo.Courses.GrokkingTheCodingInterview.Ch04_FastAndSlowPointers.PC3_CycleInACircularArray.Java;

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
        int[] arr = new int[] {1, 2, -1, 2, 2};
        assertTimeout(Duration.ofMillis(700), () -> {
            boolean expected = true;
            boolean actual = Solution.loopExists(arr);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] arr = new int[] {2, 2, -1, 2};
        assertTimeout(Duration.ofMillis(700), () -> {
            boolean expected = true;
            boolean actual = Solution.loopExists(arr);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        int[] arr = new int[] {2, 1, -1, -2};
        assertTimeout(Duration.ofMillis(700), () -> {
            boolean expected = false;
            boolean actual = Solution.loopExists(arr);
            assertEquals(expected, actual);
        });
    }
}
