package LeetCode.src.Problems.P1_P100.P65_ValidNumber.Java;

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
        String s = "0";
        assertTimeout(Duration.ofMillis(1000), () -> {
            boolean expected = true;
            boolean actual1 = Solution.isNumber1(s);
            boolean actual2 = Solution.isNumber2(s);
            assertEquals(expected, actual1);
            assertEquals(expected, actual2);
        });
    }

    @Test
    public void TrivialCase2() {
        String s = " 0.1 ";
        assertTimeout(Duration.ofMillis(1000), () -> {
            boolean expected = true;
            boolean actual1 = Solution.isNumber1(s);
            boolean actual2 = Solution.isNumber2(s);
            assertEquals(expected, actual1);
            assertEquals(expected, actual2);
        });
    }

    @Test
    public void TrivialCase3() {
        String s = "abc";
        assertTimeout(Duration.ofMillis(1000), () -> {
            boolean expected = false;
            boolean actual1 = Solution.isNumber1(s);
            boolean actual2 = Solution.isNumber2(s);
            assertEquals(expected, actual1);
            assertEquals(expected, actual2);
        });
    }

    @Test
    public void TrivialCase4() {
        String s = "1 a";
        assertTimeout(Duration.ofMillis(1000), () -> {
            boolean expected = false;
            boolean actual1 = Solution.isNumber1(s);
            boolean actual2 = Solution.isNumber2(s);
            assertEquals(expected, actual1);
            assertEquals(expected, actual2);
        });
    }

    @Test
    public void TrivialCase5() {
        String s = "2e10";
        assertTimeout(Duration.ofMillis(1000), () -> {
            boolean expected = true;
            boolean actual1 = Solution.isNumber1(s);
            boolean actual2 = Solution.isNumber2(s);
            assertEquals(expected, actual1);
            assertEquals(expected, actual2);
        });
    }
}