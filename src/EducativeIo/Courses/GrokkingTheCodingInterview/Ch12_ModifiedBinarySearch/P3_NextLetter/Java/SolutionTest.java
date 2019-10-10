package EducativeIo.Courses.GrokkingTheCodingInterview.Ch12_ModifiedBinarySearch.P3_NextLetter.Java;

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
        assertTimeout(Duration.ofMillis(500), () -> {
            String[] args = new String[0];
            assertAll(() -> Solution.main(args));
        });
    }

    @Test
    public void TrivialCase1() {
        char[] letters = new char[] {'a', 'c', 'f', 'h'};
        char key = 'f';
        assertTimeout(Duration.ofMillis(500), () -> {
            char expected = 'h';
            char actual = Solution.searchNextLetter(letters, key);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        char[] letters = new char[] {'a', 'c', 'f', 'h'};
        char key = 'b';
        assertTimeout(Duration.ofMillis(500), () -> {
            char expected = 'c';
            char actual = Solution.searchNextLetter(letters, key);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        char[] letters = new char[] {'a', 'c', 'f', 'h'};
        char key = 'm';
        assertTimeout(Duration.ofMillis(500), () -> {
            char expected = 'a';
            char actual = Solution.searchNextLetter(letters, key);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase4() {
        char[] letters = new char[] {'a', 'c', 'f', 'h'};
        char key = 'h';
        assertTimeout(Duration.ofMillis(500), () -> {
            char expected = 'a';
            char actual = Solution.searchNextLetter(letters, key);
            assertEquals(expected, actual);
        });
    }
}
