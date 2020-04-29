package LeetCode.src.Explore.Interview.GoogleInterview.LinkedList.InsertIntoACyclicSortedList.Java;

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
        Node a1 = new Node(3);
        Node a2 = new Node(4);
        Node a3 = new Node(1);
        a1.next = a2;
        a2.next = a3;
        a3.next = a1;
        assertTimeout(Duration.ofMillis(1000), () -> {
            ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(3,4,1,2));
            Node result = Solution.insert(a1, 2);
            ArrayList<Integer> actual = getList(result);
            assertEquals(expected, actual);
        });
    }

    private static ArrayList<Integer> getList(Node head) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Node temp = head; 
        if (head != null) { 
            do { 
                result.add(temp.val);
                temp = temp.next; 
            } 
            while (temp != head); 
        } 
        return result;
    } 
}