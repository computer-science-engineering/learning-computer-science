package InterviewBit.src.Courses.Programming.Level2_Arrays.Problems.Arrangement.LargestNumber.Java;

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
    public void Test1() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4);
        assertTimeout(Duration.ofMillis(500), () -> {
            // This method should run in less than specified timeout
            String actual = Solution.largestNumber(input);            
            String expected = "4321";
            assertEquals(expected, actual);
        });
    }

    @Test
    public void Test2() {
        List<Integer> input = Arrays.asList(0, 0);
        assertTimeout(Duration.ofMillis(500), () -> {
            // This method should run in less than specified timeout
            String actual = Solution.largestNumber(input);            
            String expected = "0";
            assertEquals(expected, actual);
        });
    }

    @Test
    public void Test3() {
        List<Integer> input = Arrays.asList(0, 0, 0, 0);
        assertTimeout(Duration.ofMillis(500), () -> {
            // This method should run in less than specified timeout
            String actual = Solution.largestNumber(input);            
            String expected = "0";
            assertEquals(expected, actual);
        });
    }

    @Test
    public void Test4() {
        List<Integer> input = Arrays.asList(12145, 0, 254, 1);
        assertTimeout(Duration.ofMillis(500), () -> {
            // This method runs in should run in less than specified timeout
            String actual = Solution.largestNumber(input);            
            String expected = "2541214510";
            assertEquals(expected, actual);
        });
    }

    @Test
    public void Test5() {
        List<Integer> input = Arrays.asList(0, 0, 0, 0, 1, 0);
        assertTimeout(Duration.ofMillis(500), () -> {
            // This method runs in should run in less than specified timeout
            String actual = Solution.largestNumber(input);            
            String expected = "100000";
            assertEquals(expected, actual);
        });
    }

    @Test
    public void Test6() {
        List<Integer> input = Arrays.asList(27, 271);
        assertTimeout(Duration.ofMillis(500), () -> {
            // This method runs in should run in less than specified timeout
            String actual = Solution.largestNumber(input);            
            String expected = "27271";
            assertEquals(expected, actual);
        });
    }

    @Test
    public void Test7() {
        List<Integer> input = Arrays.asList(12, 121);
        assertTimeout(Duration.ofMillis(500), () -> {
            // This method runs in should run in less than specified timeout
            String actual = Solution.largestNumber(input);            
            String expected = "12121";
            assertEquals(expected, actual);
        });
    }
}