package EducativeIo.Courses.GrokkingTheCodingInterview.Ch10_TwoHeaps.P1_FindTheMedianOfANumberStream.Java;

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
        Solution solution = new Solution();
        solution.insertNum(3);
        solution.insertNum(1);
        assertTimeout(Duration.ofMillis(700), () -> {
            double expected = 2.0;
            double actual = solution.findMedian();
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        Solution solution = new Solution();
        solution.insertNum(3);
        solution.insertNum(1);
        solution.insertNum(5);
        assertTimeout(Duration.ofMillis(700), () -> {
            double expected = 3.0;
            double actual = solution.findMedian();
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        Solution solution = new Solution();
        solution.insertNum(3);
        solution.insertNum(1);
        solution.insertNum(5);
        solution.insertNum(4);
        assertTimeout(Duration.ofMillis(700), () -> {
            double expected = 3.5;
            double actual = solution.findMedian();
            assertEquals(expected, actual);
        });
    }
}
