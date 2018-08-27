package LeetCode.src.Problems.P101_P200.P10_RegularExpressionMatching.Java;

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
        String s = "";
        String p = "a*";
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = true;
            boolean actual = Solution.isMatch(s, p);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String s = "aa";
        String p = "a";
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = false;
            boolean actual = Solution.isMatch(s, p);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        String s = "aa";
        String p = "a*";
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = true;
            boolean actual = Solution.isMatch(s, p);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase4() {
        String s = "ab";
        String p = ".*";
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = true;
            boolean actual = Solution.isMatch(s, p);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase5() {
        String s = "aab";
        String p = "c*a*b";
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = true;
            boolean actual = Solution.isMatch(s, p);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase6() {
        String s = "mississippi";
        String p = "mis*is*p*.";
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = false;
            boolean actual = Solution.isMatch(s, p);
            assertEquals(expected, actual);
        });
    }
}