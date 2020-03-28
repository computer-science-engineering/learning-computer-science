package LeetCode.src.Explore.Interview.GoogleInterview.InterviewProcess.LicenseKeyFormatting.Java;

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
        String S = "5F3Z-2e-9-w";
        int K = 4;
        assertTimeout(Duration.ofMillis(700), () -> {
            String expected = "5F3Z-2E9W";
            String actual = Solution.licenseKeyFormatting(S, K);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String S = "2-5g-3-J";
        int K = 2;
        assertTimeout(Duration.ofMillis(700), () -> {
            String expected = "2-5G-3J";
            String actual = Solution.licenseKeyFormatting(S, K);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        String S = "2-4A0r7-4k";
        int K = 4;
        assertTimeout(Duration.ofMillis(700), () -> {
            String expected = "24A0-R74K";
            String actual = Solution.licenseKeyFormatting(S, K);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase4() {
        String S = "2-4A0r7-4k";
        int K = 3;
        assertTimeout(Duration.ofMillis(700), () -> {
            String expected = "24-A0R-74K";
            String actual = Solution.licenseKeyFormatting(S, K);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase1() {
        String S = "--a-a-a-a--";
        int K = 2;
        assertTimeout(Duration.ofMillis(700), () -> {
            String expected = "AA-AA";
            String actual = Solution.licenseKeyFormatting(S, K);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase2() {
        String S = "---";
        int K = 3;
        assertTimeout(Duration.ofMillis(700), () -> {
            String expected = "";
            String actual = Solution.licenseKeyFormatting(S, K);
            assertEquals(expected, actual);
        });
    }
}