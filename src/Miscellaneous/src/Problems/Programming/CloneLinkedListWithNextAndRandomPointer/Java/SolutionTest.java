package Miscellaneous.src.Problems.Programming.CloneLinkedListWithNextAndRandomPointer.Java;

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
        // Pushing data in the linked list. 
        LinkedList list = new LinkedList(new Node(5)); 
        list.push(4); 
        list.push(3); 
        list.push(2); 
        list.push(1); 
  
        // Setting up random references. 
        list.head.random = list.head.next.next; 
        list.head.next.random = 
            list.head.next.next.next; 
        list.head.next.next.random = 
            list.head.next.next.next.next; 
        list.head.next.next.next.random = 
            list.head.next.next.next.next.next; 
        list.head.next.next.next.next.random = 
            list.head.next; 
        assertTimeout(Duration.ofMillis(500), () -> {
            ArrayList<Integer> expectedData = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
            ArrayList<Integer> expectedRandomData = new ArrayList<Integer>(Arrays.asList(3, 4, 5, -1, 2));
            // Making a clone of the original linked list. 
            LinkedList actualClone = list.clone();
            ArrayList<Integer> actualData = actualClone.getDataArray();
            ArrayList<Integer> actualRandomData = actualClone.getRandomDataArray();
            assertEquals(expectedData, actualData);
            assertEquals(expectedRandomData, actualRandomData);
        });
    }
}