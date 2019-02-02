package LeetCode.src.Problems.P201_P300.P237_DeleteNodeInALinkedList.Java;

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
        assertTimeout(Duration.ofMillis(500), () -> {
            ListNode a1 = new ListNode(4);
            ListNode a2 = new ListNode(5);
            ListNode a3 = new ListNode(1);
            ListNode a4 = new ListNode(9);
            a1.next = a2;
            a2.next = a3;
            a3.next = a4;
            int[] expected = {4, 5, 9};
            Solution.deleteNode(a3);
            int[] actual = new int[3];
            int i=0;
            while(a1.next != null) {
                actual[i++] = a1.val;
                a1 = a1.next;
            }
            actual[i] = a1.val;
            assertArrayEquals(expected, actual);
        });
    }
}