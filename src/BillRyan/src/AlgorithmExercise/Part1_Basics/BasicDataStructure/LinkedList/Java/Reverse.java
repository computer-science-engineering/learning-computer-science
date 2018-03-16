package BillRyan.src.AlgorithmExercise.Part1_Basics.BasicDataStructure.LinkedList.Java;

public class Reverse {

    public DListNode reverseDList(DListNode head) {
        DListNode curr = null;
        while (head != null) {
            curr = head;
            head = curr.next;
            curr.next = curr.prev;
            curr.prev = head;
        }
        return curr;
    }

    // iterative method
    public ListNode reverseListNodeIterative(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // recursive method
    public ListNode reverseListNodeRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseListNodeRecursive(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
}
