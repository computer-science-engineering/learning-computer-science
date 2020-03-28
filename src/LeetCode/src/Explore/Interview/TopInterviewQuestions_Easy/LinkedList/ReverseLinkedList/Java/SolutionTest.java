package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.LinkedList.ReverseLinkedList.Java;

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
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(8);
        ListNode a3 = new ListNode(5);
        ListNode a4 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(8);
        ListNode b3 = new ListNode(5);
        ListNode b4 = new ListNode(3);
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        assertTimeout(Duration.ofMillis(700), () -> {
            int[] expected = {3, 5, 8, 1};
            
            ListNode result_iter = Solution.reverseList(a1);
            int[] actual_iter = new int[4];
            int i=0;
            while(result_iter.next != null) {
                actual_iter[i++] = result_iter.val;
                result_iter = result_iter.next;
            }
            actual_iter[i] = result_iter.val;
            assertArrayEquals(expected, actual_iter);

            ListNode result_rec = Solution.reverseList_recursive(b1);
            int[] actual_rec = new int[4];
            int j=0;
            while(result_rec.next != null) {
                actual_rec[j++] = result_rec.val;
                result_rec = result_rec.next;
            }
            actual_rec[j] = result_rec.val;
            assertArrayEquals(expected, actual_rec);
        });
    }
}