package InterviewBit.src.Courses.Programming.Level2_Arrays.Problems.BucketingOrSorting.WaveArray;

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
    public void TrivialCase1() {
        int[] input = {1, 2, 3, 4};
        assertTimeout(Duration.ofMillis(200), () -> {
            int[] actual = Solution.wave(input);
            int[] expected = {2, 1, 4, 3};
            assertArrayEquals(expected, actual);
        });
    }
}