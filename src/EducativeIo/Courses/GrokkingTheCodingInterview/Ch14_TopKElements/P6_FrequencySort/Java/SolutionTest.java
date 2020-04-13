package EducativeIo.Courses.GrokkingTheCodingInterview.Ch14_TopKElements.P6_FrequencySort.Java;

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
        String str = "Programming";
        assertTimeout(Duration.ofMillis(700), () -> {
            String expected = "rrggmmPiano";
            String actual = Solution.sortCharacterByFrequency(str);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String str = "abcbab";
        assertTimeout(Duration.ofMillis(700), () -> {
            String expected = "bbbaac";
            String actual = Solution.sortCharacterByFrequency(str);
            assertEquals(expected, actual);
        });
    }
}
