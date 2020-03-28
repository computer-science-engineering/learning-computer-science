package EducativeIo.Courses.GrokkingTheCodingInterview.Ch12_ModifiedBinarySearch.P5_SearchInASortedInfiniteArray.Java;

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
        ArrayReader reader =
                new ArrayReader(new int[] {4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30});
        int key = 16;
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 6;
            int actual = Solution.search(reader, key);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        ArrayReader reader =
                new ArrayReader(new int[] {4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30});
        int key = 11;
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = -1;
            int actual = Solution.search(reader, key);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        ArrayReader reader = new ArrayReader(new int[] {1, 3, 8, 10, 15});
        int key = 15;
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = 4;
            int actual = Solution.search(reader, key);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase4() {
        ArrayReader reader = new ArrayReader(new int[] {1, 3, 8, 10, 15});
        int key = 200;
        assertTimeout(Duration.ofMillis(700), () -> {
            int expected = -1;
            int actual = Solution.search(reader, key);
            assertEquals(expected, actual);
        });
    }
}
