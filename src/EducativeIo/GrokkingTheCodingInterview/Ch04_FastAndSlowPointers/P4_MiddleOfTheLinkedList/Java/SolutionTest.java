package EducativeIo.GrokkingTheCodingInterview.Ch04_FastAndSlowPointers.P4_MiddleOfTheLinkedList.Java;

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
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 3;
            int actual = Solution.findMiddle(head).value;
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 4;
            int actual = Solution.findMiddle(head).value;
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        assertTimeout(Duration.ofMillis(500), () -> {
            int expected = 4;
            int actual = Solution.findMiddle(head).value;
            assertEquals(expected, actual);
        });
    }
}
