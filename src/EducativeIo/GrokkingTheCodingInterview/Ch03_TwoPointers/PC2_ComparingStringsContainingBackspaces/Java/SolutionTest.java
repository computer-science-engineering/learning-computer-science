package EducativeIo.GrokkingTheCodingInterview.Ch03_TwoPointers.PC2_ComparingStringsContainingBackspaces.Java;

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
        String str1 = "xy#z";
        String str2 = "xzz#";
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = true;
            boolean actual = Solution.compare(str1, str2);
            boolean actual2 = Solution.compare2(str1, str2);
            assertEquals(expected, actual);
            assertEquals(expected, actual2);
        });
    }

    @Test
    public void TrivialCase2() {
        String str1 = "xy#z";
        String str2 = "xyz#";
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = false;
            boolean actual = Solution.compare(str1, str2);
            boolean actual2 = Solution.compare2(str1, str2);
            assertEquals(expected, actual);
            assertEquals(expected, actual2);
        });
    }

    @Test
    public void TrivialCase3() {
        String str1 = "xp#";
        String str2 = "xyz##";
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = true;
            boolean actual = Solution.compare(str1, str2);
            boolean actual2 = Solution.compare2(str1, str2);
            assertEquals(expected, actual);
            assertEquals(expected, actual2);
        });
    }

    @Test
    public void TrivialCase4() {
        String str1 = "xywrrmp";
        String str2 = "xywrrmu#p";
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = true;
            boolean actual = Solution.compare(str1, str2);
            boolean actual2 = Solution.compare2(str1, str2);
            assertEquals(expected, actual);
            assertEquals(expected, actual2);
        });
    }
}
