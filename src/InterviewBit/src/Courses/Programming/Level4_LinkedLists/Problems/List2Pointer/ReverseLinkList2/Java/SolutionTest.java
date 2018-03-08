package InterviewBit.src.Courses.Programming.Level4_LinkedLists.Problems.List2Pointer.ReverseLinkList2.Java;

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
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        assertTimeout(Duration.ofMillis(500), () -> {
            int[] expected = {1, 4, 3, 2, 5};
            ListNode result = Solution.reverseBetween(a1, 2, 4);
            int[] actual = new int[5];
            int i=0;
            while(result.next != null) {
                actual[i++] = result.val;
                result = result.next;
            }
            actual[i] = result.val;
            assertArrayEquals(expected, actual);
        });
    }
}