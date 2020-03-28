package EducativeIo.Courses.GrokkingTheCodingInterview.Ch04_FastAndSlowPointers.PC2_RearrangeALinkedList.Java;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        assertTimeout(Duration.ofMillis(700), () -> {
            ListNode head = new ListNode(2);
            head.next = new ListNode(4);
            head.next.next = new ListNode(6);
            head.next.next.next = new ListNode(8);
            head.next.next.next.next = new ListNode(10);
            head.next.next.next.next.next = new ListNode(12);
            List<Integer> expected = Arrays.asList(2, 12, 4, 10, 6, 8);
            Solution.reorder(head);
            List<Integer> actual = new ArrayList<Integer>();
            while (head != null) {
                actual.add(head.value);
                head = head.next;
            }
            assertEquals(expected, actual);
        });
    }
}
