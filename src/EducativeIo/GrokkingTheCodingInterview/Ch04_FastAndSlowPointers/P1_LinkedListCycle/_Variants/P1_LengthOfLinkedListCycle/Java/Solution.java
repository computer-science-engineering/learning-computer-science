package EducativeIo.GrokkingTheCodingInterview.Ch04_FastAndSlowPointers.P1_LinkedListCycle._Variants.P1_LengthOfLinkedListCycle.Java;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle length: " + findCycleLength(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle length: " + findCycleLength(head));
    }

    public static int findCycleLength(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return CalculateLength(slow);
            }
        }
        return 0;
    }

    private static int CalculateLength(ListNode start) {
        int length = 0;
        ListNode startPointer = start;
        do {
            start = start.next;
            length++;
        } while (start != startPointer);
        return length;
    }
}
