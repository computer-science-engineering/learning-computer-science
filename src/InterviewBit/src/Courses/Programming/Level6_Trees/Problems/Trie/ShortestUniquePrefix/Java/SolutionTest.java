package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.Trie.ShortestUniquePrefix.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

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
        ArrayList<String> input = new ArrayList<String>(Arrays.asList("zebra", "dog", "duck", "dove"));
        assertTimeout(Duration.ofMillis(700), () -> {
            ArrayList<String> expected_ordered = new ArrayList<String>(Arrays.asList("z", "dog", "du", "dov"));
            ArrayList<String> expected_all = new ArrayList<String>(Arrays.asList("dog", "dov", "du", "z"));
            ArrayList<String> actual_ordered = Solution.prefix(input);
            assertEquals(expected_ordered, actual_ordered);
            ArrayList<String> actual_all = Solution.prefix_all(input);
            assertEquals(expected_all, actual_all);
            ArrayList<String> actual_editorial = Solution.prefix_editorial(input);
            assertEquals(expected_ordered, actual_editorial);
        });
    }
}