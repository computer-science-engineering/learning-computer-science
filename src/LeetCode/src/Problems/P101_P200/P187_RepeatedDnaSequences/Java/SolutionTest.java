package LeetCode.src.Problems.P101_P200.P187_RepeatedDnaSequences.Java;

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
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        assertTimeout(Duration.ofMillis(500), () -> {
            List<String> expected = Arrays.asList("AAAAACCCCC", "CCCCCAAAAA");
            List<String> actual = Solution.findRepeatedDnaSequences(s);
            assertEquals(expected, actual);
        });
    }
}