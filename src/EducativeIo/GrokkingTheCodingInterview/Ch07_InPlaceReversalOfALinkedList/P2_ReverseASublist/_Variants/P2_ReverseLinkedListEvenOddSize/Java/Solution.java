package EducativeIo.GrokkingTheCodingInterview.Ch07_InPlaceReversalOfALinkedList.P2_ReverseASublist._Variants.P2_ReverseLinkedListEvenOddSize.Java;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = reverse(head);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }

        System.out.println();

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next = new ListNode(6);

        ListNode result2 = reverse(head2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result2 != null) {
            System.out.print(result2.value + " ");
            result2 = result2.next;
        }
    }

    public static ListNode reverse(ListNode head) {
        ListNode current = head;
        int size = 0;
        while (current != null) {
            current = current.next;
            size++;
        }

        if (size % 2 == 0) { // even
            head = reverseSubList(head, 1, size / 2);
            head = reverseSubList(head, (size / 2) + 1, size);
        } else { // odd
            head = reverseSubList(head, 1, size / 2);
            head = reverseSubList(head, (size / 2) + 2, size);
        }

        return head;
    }

    private static ListNode reverseSubList(ListNode head, int p, int q) {
        if (p == q) {
            return head;
        }

        // after skipping 'p-1' nodes, current will point to 'p'th node
        ListNode current = head, previous = null;
        for (int i = 0; current != null && i < p - 1; ++i) {
            previous = current;
            current = current.next;
        }

        // we are interested in three parts of the LinkedList, part before index 'p',
        // part between 'p' and 'q', and the part after index 'q'
        ListNode lastNodeOfFirstPart = previous; // points to the node at index 'p-1'
        // after reversing the LinkedList 'current' will become the last node of the sub-list
        ListNode lastNodeOfSubList = current;
        ListNode next = null; // will be used to temporarily store the next node
        // reverse nodes between 'p' and 'q'
        for (int i = 0; current != null && i < q - p + 1; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        // connect with the first part
        if (lastNodeOfFirstPart != null) {
            lastNodeOfFirstPart.next = previous; // 'previous' is now the first node of the sub-list
        } else { // this means p == 1 i.e., we are changing the first node (head) of the LinkedList
            head = previous;
        }

        // connect with the last part
        lastNodeOfSubList.next = current;

        return head;
    }
}
