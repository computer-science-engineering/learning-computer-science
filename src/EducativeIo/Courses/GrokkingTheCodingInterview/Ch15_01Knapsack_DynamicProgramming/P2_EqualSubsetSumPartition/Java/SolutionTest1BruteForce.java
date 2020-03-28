package EducativeIo.Courses.GrokkingTheCodingInterview.Ch15_01Knapsack_DynamicProgramming.P2_EqualSubsetSumPartition.Java;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SolutionTest1BruteForce {

    Solution1BruteForce solution;

    @BeforeEach
    public void setUp() throws Exception {
        solution = new Solution1BruteForce();
    }

    @AfterEach
    public void tearDown() throws Exception {
        solution = null;
    }

    @Test
    public void MainFunction() {
        assertTimeout(Duration.ofMillis(700), () -> {
            String[] args = new String[0];
            assertAll(() -> Solution1BruteForce.main(args));
        });
    }

    @Test
    public void TrivialCase1() {
        int[] num = {1, 2, 3, 4};
        Solution1BruteForce ps = new Solution1BruteForce();
        assertTimeout(Duration.ofMillis(700), () -> {
            boolean expected = true;
            boolean actual = ps.canPartition(num);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] num = {1, 1, 3, 4, 7};
        Solution1BruteForce ps = new Solution1BruteForce();
        assertTimeout(Duration.ofMillis(700), () -> {
            boolean expected = true;
            boolean actual = ps.canPartition(num);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        int[] num = {2, 3, 4, 6};
        Solution1BruteForce ps = new Solution1BruteForce();
        assertTimeout(Duration.ofMillis(700), () -> {
            boolean expected = false;
            boolean actual = ps.canPartition(num);
            assertEquals(expected, actual);
        });
    }
}
