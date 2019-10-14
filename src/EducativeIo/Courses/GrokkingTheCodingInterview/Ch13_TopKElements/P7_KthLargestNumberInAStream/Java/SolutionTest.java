package EducativeIo.Courses.GrokkingTheCodingInterview.Ch13_TopKElements.P7_KthLargestNumberInAStream.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class SolutionTest {

    Solution solution;

    @BeforeEach
    public void setUp() throws Exception {
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
        int[] input = new int[] {3, 1, 5, 12, 2, 11};
        solution = new Solution(input, 4);
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected1 = 5;
            int actual1 = solution.add(6);
            assertEquals(expected1, actual1);
            int expected2 = 6;
            int actual2 = solution.add(13);
            assertEquals(expected2, actual2);
            int expected3 = 6;
            int actual3 = solution.add(4);
            assertEquals(expected3, actual3);
        });
    }
}
