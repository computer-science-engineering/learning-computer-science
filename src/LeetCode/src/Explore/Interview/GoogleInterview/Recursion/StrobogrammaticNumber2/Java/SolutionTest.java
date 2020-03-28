package LeetCode.src.Explore.Interview.GoogleInterview.Recursion.StrobogrammaticNumber2.Java;

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
        assertTimeout(Duration.ofMillis(700), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        int n = 2;
        assertTimeout(Duration.ofMillis(700), () -> {
            List<String> expected = Arrays.asList("11", "69", "88", "96");;
            List<String> actual = Solution.findStrobogrammatic(n);
            assertEquals(expected, actual);
        });
    }
}