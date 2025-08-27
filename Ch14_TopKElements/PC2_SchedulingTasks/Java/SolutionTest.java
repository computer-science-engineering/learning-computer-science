package EducativeIo.Courses.GrokkingTheCodingInterview.Ch14_TopKElements.PC2_SchedulingTasks.Java;

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
        char[] tasks = new char[] {'a', 'a', 'a', 'b', 'c', 'c'};
        int k = 2;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 7;
            int actual = Solution.scheduleTasks(tasks, k);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        char[] tasks = new char[] {'a', 'b', 'a'};
        int k = 3;
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 5;
            int actual = Solution.scheduleTasks(tasks, k);
            assertEquals(expected, actual);
        });
    }
}
