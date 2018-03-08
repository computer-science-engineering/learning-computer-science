package Firecode.src.Problems.Level1.BinarySearchOnArrayOfIntegers.Java;

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
        int[] arr = {2,5,7,8,9,12};
        int n = 8;
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = true;
            boolean actual = Solution.binarySearch(arr, n);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] arr = {2,5,7,9,12};
        int n = 8;
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = false;
            boolean actual = Solution.binarySearch(arr, n);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        int[] arr = {2,5,7,9,12};
        int n = 12;
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = true;
            boolean actual = Solution.binarySearch(arr, n);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase4() {
        int[] arr = {2,5,7,9,12};
        int n = 2;
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = true;
            boolean actual = Solution.binarySearch(arr, n);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase1() {
        int[] arr = {2};
        int n = 4;
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = false;
            boolean actual = Solution.binarySearch(arr, n);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase2() {
        int[] arr = {2};
        int n = 2;
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = true;
            boolean actual = Solution.binarySearch(arr, n);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase3() {
        int[] arr = {};
        int n = 4;
        assertTimeout(Duration.ofMillis(500), () -> {
            boolean expected = false;
            boolean actual = Solution.binarySearch(arr, n);
            assertEquals(expected, actual);
        });
    }
}