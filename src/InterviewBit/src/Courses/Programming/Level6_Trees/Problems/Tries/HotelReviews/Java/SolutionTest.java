package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.Tries.HotelReviews.Java;

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
        assertTimeout(Duration.ofMillis(500), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        String A = "cool_ice_wifi";
        ArrayList<String> B = new ArrayList<String>(Arrays.asList(
            "water_is_cool", "cold_ice_drink", "cool_wifi_speed"));
        assertTimeout(Duration.ofMillis(500), () -> {
            ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(2, 0, 1));
            ArrayList<Integer> actual1 = Solution.solve(A, B);
            assertEquals(expected, actual1);
            ArrayList<Integer> actual2 = solution.solve_editorial(A, B);
            assertEquals(expected, actual2);
        });
    }
}