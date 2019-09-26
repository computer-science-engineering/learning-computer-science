package EducativeIo.Courses.GrokkingTheCodingInterview.Ch11_Subsets.P4_StringPermutationsByChangingCase.Java;

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
        String str = "ad52";
        assertTimeout(Duration.ofMillis(500), () -> {
            List<String> expected = Arrays.asList("ad52", "Ad52", "aD52", "AD52");
            List<String> actual = Solution.findLetterCaseStringPermutations(str);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String str = "ab7c";
        assertTimeout(Duration.ofMillis(500), () -> {
            List<String> expected =
                    Arrays.asList("ab7c", "Ab7c", "aB7c", "AB7c", "ab7C", "Ab7C", "aB7C", "AB7C");
            List<String> actual = Solution.findLetterCaseStringPermutations(str);
            assertEquals(expected, actual);
        });
    }
}
