package InterviewBit.src.Courses.Programming.Level4_LinkedLists.Examples.IntersectionOfLinkedLists.Java;

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
        ListNode a2 = new ListNode(3);
        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(4);
        ListNode b3 = new ListNode(5);
        ListNode c1 = new ListNode(6);
        ListNode c2 = new ListNode(7);
        a1.next = a2;
        a2.next = c1;
        b1.next = b2;
        b2.next = b3;
        b3.next = c1;
        c1.next = c2;
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 6;
            int actual = Solution.getIntersectionNode(a1, b1).val;
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode b1 = new ListNode(3);
        ListNode b2 = new ListNode(4);
        ListNode b3 = new ListNode(5);
        ListNode c1 = new ListNode(8);
        ListNode c2 = new ListNode(9);
        ListNode c3 = new ListNode(7);
        a1.next = a2;
        a2.next = c1;
        b1.next = b2;
        b2.next = b3;
        b3.next = c1;
        c1.next = c2;
        c2.next = c3;
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 8;
            int actual = Solution.getIntersectionNode(a1, b1).val;
            assertEquals(expected, actual);
        });
    }
}