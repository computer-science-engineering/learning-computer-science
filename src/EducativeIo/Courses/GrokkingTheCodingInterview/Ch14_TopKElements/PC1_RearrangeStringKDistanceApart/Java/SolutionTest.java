package EducativeIo.Courses.GrokkingTheCodingInterview.Ch14_TopKElements.PC1_RearrangeStringKDistanceApart.Java;

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
        String str = "mmpp";
        int k = 2;
        assertTimeout(Duration.ofMillis(700), () -> {
            String expected = "pmpm";
            String actual = Solution.reorganizeString(str, k);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String str = "Programming";
        int k = 3;
        assertTimeout(Duration.ofMillis(700), () -> {
            String expected = "rgmPrgmiano";
            String actual = Solution.reorganizeString(str, k);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        String str = "aab";
        int k = 2;
        assertTimeout(Duration.ofMillis(700), () -> {
            String expected = "aba";
            String actual = Solution.reorganizeString(str, k);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase4() {
        String str = "aappa";
        int k = 3;
        assertTimeout(Duration.ofMillis(700), () -> {
            String expected = "";
            String actual = Solution.reorganizeString(str, k);
            assertEquals(expected, actual);
        });
    }
}
