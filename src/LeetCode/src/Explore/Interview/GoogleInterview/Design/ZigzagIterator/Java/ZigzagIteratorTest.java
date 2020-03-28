package LeetCode.src.Explore.Interview.GoogleInterview.Design.ZigzagIterator.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class ZigzagIteratorTest {
    
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
    public void TrivialCase1() {
        List<Integer> v1 = Arrays.asList(1,2);
        List<Integer> v2 = Arrays.asList(3,4,5,6);
        assertTimeout(Duration.ofMillis(700), () -> {
            List<Integer> expected = Arrays.asList(1, 3, 2, 4, 5, 6);
            List<Integer> actual = new ArrayList<Integer>();
            ZigzagIterator i = new ZigzagIterator(v1, v2);
            while (i.hasNext()) actual.add(i.next());
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase1() {
        List<Integer> v1 = Arrays.asList(1,2,3);
        List<Integer> v2 = Arrays.asList(4,5,6,7);
        List<Integer> v3 = Arrays.asList(8,9);
        List<List<Integer>> listOfLists = new ArrayList<List<Integer>>();
        listOfLists.add(v1);
        listOfLists.add(v2);
        listOfLists.add(v3);
        assertTimeout(Duration.ofMillis(700), () -> {
            List<Integer> expected = Arrays.asList(1,4,8,2,5,9,3,6,7);
            List<Integer> actual = new ArrayList<Integer>();
            ZigzagIterator i = new ZigzagIterator(listOfLists);
            while (i.hasNext()) actual.add(i.next());
            assertEquals(expected, actual);
        });
    }
}