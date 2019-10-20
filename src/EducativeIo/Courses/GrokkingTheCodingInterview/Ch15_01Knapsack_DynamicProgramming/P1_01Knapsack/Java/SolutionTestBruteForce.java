package EducativeIo.Courses.GrokkingTheCodingInterview.Ch15_01Knapsack_DynamicProgramming.P1_01Knapsack.Java;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SolutionTestBruteForce {

    SolutionBruteForce solution;

    @BeforeEach
    public void setUp() throws Exception {
        solution = new SolutionBruteForce();
    }

    @AfterEach
    public void tearDown() throws Exception {
        solution = null;
    }

    @Test
    public void MainFunction() {
        assertTimeout(Duration.ofMillis(500), () -> {
            String[] args = new String[0];
            assertAll(() -> SolutionBruteForce.main(args));
        });
    }

    @Test
    public void TrivialCase1() {
        SolutionBruteForce ks = new SolutionBruteForce();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int capacity = 7;
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 22;
            int actual = ks.solveKnapsack(profits, weights, capacity);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        SolutionBruteForce ks = new SolutionBruteForce();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int capacity = 6;
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 17;
            int actual = ks.solveKnapsack(profits, weights, capacity);
            assertEquals(expected, actual);
        });
    }
}
