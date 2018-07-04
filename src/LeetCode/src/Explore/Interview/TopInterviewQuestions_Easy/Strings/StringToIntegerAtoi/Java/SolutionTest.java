package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.Strings.StringToIntegerAtoi.Java;

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
        String str = "   -42";
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = -42;
            int actual = Solution.myAtoi(str);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String str = "42";
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 42;
            int actual = Solution.myAtoi(str);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        String str = "4193 with words";
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 4193;
            int actual = Solution.myAtoi(str);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase1() {
        String str = "words and 987";
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 0;
            int actual = Solution.myAtoi(str);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase2() {
        String str = "-91283472332";
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = -2147483648;
            int actual = Solution.myAtoi(str);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase3() {
        String str = " ";
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 0;
            int actual = Solution.myAtoi(str);
            assertEquals(expected, actual);
        });
    }
}