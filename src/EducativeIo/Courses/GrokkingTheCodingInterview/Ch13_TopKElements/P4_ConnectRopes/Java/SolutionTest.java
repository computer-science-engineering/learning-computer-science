package EducativeIo.Courses.GrokkingTheCodingInterview.Ch13_TopKElements.P4_ConnectRopes.Java;

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
        int[] ropeLengths = new int[] {1, 3, 11, 5};
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 33;
            int actual = Solution.minimumCostToConnectRopes(ropeLengths);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] ropeLengths = new int[] {1, 3, 11, 5, 2};
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 42;
            int actual = Solution.minimumCostToConnectRopes(ropeLengths);
            assertEquals(expected, actual);
        });
    }
}
