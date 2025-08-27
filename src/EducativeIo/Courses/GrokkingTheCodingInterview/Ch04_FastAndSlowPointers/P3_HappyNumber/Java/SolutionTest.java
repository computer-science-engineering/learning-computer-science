package EducativeIo.Courses.GrokkingTheCodingInterview.Ch04_FastAndSlowPointers.P3_HappyNumber.Java;

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
        int num = 23;
        assertTimeout(Duration.ofMillis(1000), () -> {
            boolean expected = true;
            boolean actual = Solution.find(num);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int num = 12;
        assertTimeout(Duration.ofMillis(1000), () -> {
            boolean expected = false;
            boolean actual = Solution.find(num);
            assertEquals(expected, actual);
        });
    }
}
