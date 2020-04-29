package EducativeIo.Courses.GrokkingTheCodingInterview.Ch16_01Knapsack_DynamicProgramming.P1_01Knapsack.Java;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SolutionTest4BottomUpDpSpaceOptimized {

    Solution4BottomUpDpSpaceOptimized solution;

    @BeforeEach
    public void setUp() throws Exception {
        solution = new Solution4BottomUpDpSpaceOptimized();
    }

    @AfterEach
    public void tearDown() throws Exception {
        solution = null;
    }

    @Test
    public void MainFunction() {
        assertTimeout(Duration.ofMillis(1000), () -> {
            String[] args = new String[0];
            assertAll(() -> Solution4BottomUpDpSpaceOptimized.main(args));
        });
    }

    @Test
    public void TrivialCase1() {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int capacity = 7;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 22;
            int actual =
                    Solution4BottomUpDpSpaceOptimized.solveKnapsack(profits, weights, capacity);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int capacity = 6;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 17;
            int actual =
                    Solution4BottomUpDpSpaceOptimized.solveKnapsack(profits, weights, capacity);
            assertEquals(expected, actual);
        });
    }
}
