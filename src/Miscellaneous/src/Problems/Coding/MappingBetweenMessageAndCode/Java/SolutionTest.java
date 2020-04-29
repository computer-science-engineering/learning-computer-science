package Miscellaneous.src.Problems.Coding.MappingBetweenMessageAndCode.Java;

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
        String message = "red green blue";
        String code = "abc";
        assertTimeout(Duration.ofMillis(1000), () -> {
            boolean expected = true;
            boolean actual = Solution.doesMappingExist(message, code);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String message = "red green blue";
        String code = "abb";
        assertTimeout(Duration.ofMillis(1000), () -> {
            boolean expected = false;
            boolean actual = Solution.doesMappingExist(message, code);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        String message = "red blue blue";
        String code = "abb";
        assertTimeout(Duration.ofMillis(1000), () -> {
            boolean expected = true;
            boolean actual = Solution.doesMappingExist(message, code);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase4() {
        String message = "red blue red";
        String code = "abaa";
        assertTimeout(Duration.ofMillis(1000), () -> {
            boolean expected = false;
            boolean actual = Solution.doesMappingExist(message, code);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase5() {
        String message = "red blue red";
        String code = "abaa";
        assertTimeout(Duration.ofMillis(1000), () -> {
            boolean expected = false;
            boolean actual = Solution.doesMappingExist(message, code);
            assertEquals(expected, actual);
        });
    }
}