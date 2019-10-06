package EducativeIo.Courses.GrokkingTheCodingInterview.Ch11_Subsets.P6_UniqueGeneralizedAbbreviations.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
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
        String word = "BAT";
        assertTimeout(Duration.ofMillis(500), () -> {
            List<String> expected =
                    Arrays.asList("3", "2T", "1A1", "1AT", "B2", "B1T", "BA1", "BAT");
            List<String> actual1 = Solution.generateGeneralizedAbbreviation(word);
            assertEquals(expected, actual1);
            List<String> actual2 = Solution.generateGeneralizedAbbreviation2(word);
            assertEquals(expected, actual2);
        });
    }

    @Test
    public void TrivialCase2() {
        String word = "code";
        assertTimeout(Duration.ofMillis(500), () -> {
            List<String> expected = Arrays.asList("4", "3e", "2d1", "2de", "1o2", "1o1e", "1od1",
                    "1ode", "c3", "c2e", "c1d1", "c1de", "co2", "co1e", "cod1", "code");
            List<String> actual1 = Solution.generateGeneralizedAbbreviation(word);
            assertEquals(expected, actual1);
            List<String> actual2 = Solution.generateGeneralizedAbbreviation2(word);
            assertEquals(expected, actual2);
        });
    }
}
