package Firecode.src.Problems.Level1.FindFirstNonDuplicateCharacterInAString.Java;

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
        String input = "abcdcd";
        assertTimeout(Duration.ofMillis(700), () -> {
            Character expected = 'a';
            Character actual = Solution.firstNonRepeatedCharacter(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        String input = "aabcdc";
        assertTimeout(Duration.ofMillis(700), () -> {
            Character expected = 'b';
            Character actual = Solution.firstNonRepeatedCharacter(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase1() {
        String input = "aaaa";
        assertTimeout(Duration.ofMillis(700), () -> {
            Character expected = null;
            Character actual = Solution.firstNonRepeatedCharacter(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase2() {
        String input = "b";
        assertTimeout(Duration.ofMillis(700), () -> {
            Character expected = 'b';
            Character actual = Solution.firstNonRepeatedCharacter(input);
            assertEquals(expected, actual);
        });
    }
}