package EducativeIo.Courses.GrokkingTheCodingInterview.Ch14_TopKElements.P11_RearrangeString.Java;

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
        String str = "aappp";
        assertTimeout(Duration.ofMillis(1000), () -> {
            String expected = "papap";
            String actual = Solution.rearrangeString(str);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String str = "Programming";
        assertTimeout(Duration.ofMillis(1000), () -> {
            String expected = "rgmrgmPiano";
            String actual = Solution.rearrangeString(str);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        String str = "aapa";
        assertTimeout(Duration.ofMillis(1000), () -> {
            String expected = "";
            String actual = Solution.rearrangeString(str);
            assertEquals(expected, actual);
        });
    }
}
