package EducativeIo.Courses.GrokkingTheCodingInterview.Ch15_KWayMerge.P3_KthSmallestNumberInASortedMatrix.Java;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SolutionAlternative1Test {

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
        int matrix[][] = {{2, 6, 8}, {3, 7, 10}, {5, 8, 11}};
        int k = 5;
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 7;
            int actual = SolutionAlternative1.findKthSmallest(matrix, k);
            assertEquals(expected, actual);
        });
    }
}
