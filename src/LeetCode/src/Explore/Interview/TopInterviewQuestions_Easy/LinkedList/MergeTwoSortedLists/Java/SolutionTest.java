package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.LinkedList.MergeTwoSortedLists.Java;

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
    public void TrivialCase1_Recursive() {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;
        assertTimeout(Duration.ofMillis(500), () -> {
            int[] expected = {1, 1, 2, 3, 4, 4};

            ListNode result_recursive = Solution.mergeTwoLists(a1, b1);
            int[] actual_recursive = new int[6];
            int i=0;
            while(result_recursive.next != null) {
                actual_recursive[i++] = result_recursive.val;
                result_recursive = result_recursive.next;
            }
            actual_recursive[i] = result_recursive.val;
            assertArrayEquals(expected, actual_recursive);
        });
    }

    @Test
    public void TrivialCase1_Iterative() {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;
        assertTimeout(Duration.ofMillis(500), () -> {
            int[] expected = {1, 1, 2, 3, 4, 4};
            ListNode result_iterative = Solution.mergeTwoLists_Iterative(a1, b1);
            int[] actual_iterative = new int[6];
            int j=0;
            while(result_iterative.next != null) {
                actual_iterative[j++] = result_iterative.val;
                result_iterative = result_iterative.next;
            }
            actual_iterative[j] = result_iterative.val;
            assertArrayEquals(expected, actual_iterative);
        });
    }
}