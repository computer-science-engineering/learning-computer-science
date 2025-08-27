package EducativeIo.Courses.GrokkingTheCodingInterview.Ch03_TwoPointers.PC4_MaximumTrappingWater.Java;

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
        int[] buildingHeights = new int[] {1, 3, 5, 4, 1};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 6;
            int actual = Solution.findMaxWater(buildingHeights);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] buildingHeights = new int[] {3, 2, 5, 4, 2};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 9;
            int actual = Solution.findMaxWater(buildingHeights);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        int[] buildingHeights = new int[] {1, 4, 3, 2, 5, 8, 4};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 20;
            int actual = Solution.findMaxWater(buildingHeights);
            assertEquals(expected, actual);
        });
    }
}
