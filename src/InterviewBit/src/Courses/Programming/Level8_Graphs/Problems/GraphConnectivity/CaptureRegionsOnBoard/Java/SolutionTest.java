package InterviewBit.src.Courses.Programming.Level8_Graphs.Problems.GraphConnectivity.CaptureRegionsOnBoard.Java;

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
        assertTimeout(Duration.ofMillis(1000), () -> {
             String[] args = new String[0];
             assertAll(() -> Solution.main(args));
        });
    }
    
    @Test
    public void TrivialCase1() {
        ArrayList<ArrayList<Character>> a = new ArrayList<ArrayList<Character>>();
        a.add(new ArrayList<Character>(Arrays.asList('X', 'X', 'X', 'X')));
        a.add(new ArrayList<Character>(Arrays.asList('X', 'O', 'O', 'X')));
        a.add(new ArrayList<Character>(Arrays.asList('X', 'X', 'O', 'X')));
        a.add(new ArrayList<Character>(Arrays.asList('X', 'O', 'X', 'X')));
        assertTimeout(Duration.ofMillis(1000), () -> {
            ArrayList<ArrayList<Character>> expected = new ArrayList<ArrayList<Character>>();
            expected.add(new ArrayList<Character>(Arrays.asList('X', 'X', 'X', 'X')));
            expected.add(new ArrayList<Character>(Arrays.asList('X', 'X', 'X', 'X')));
            expected.add(new ArrayList<Character>(Arrays.asList('X', 'X', 'X', 'X')));
            expected.add(new ArrayList<Character>(Arrays.asList('X', 'O', 'X', 'X')));
            Solution.solve(a);
            ArrayList<ArrayList<Character>> actual = a;
            assertEquals(expected, actual);
        });
    }
}