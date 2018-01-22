package InterviewBit.src.Courses.Programming.Level4_LinkedLists.Problems.PointerMove.ReorderList.Java;

public class Solution {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(6);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        ListNode result = reorderList(a1);
        while(result.next != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
        System.out.print(result.val);
    }
    
    public static ListNode reorderList(ListNode A) {
        if(A == null) {
            return null;
        }

        if (A.next == null) {
            return A;
        }
            
        //Find the middle of the list
        ListNode p1 = A;
        ListNode p2 = A;
        while(p2.next != null && p2.next.next != null) { 
            p1 = p1.next;
            p2 = p2.next.next;
        }
        
        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode endFirstHalf = p1;
        ListNode startSecondHalf = p1.next;
        while(startSecondHalf.next != null) {
            ListNode current = startSecondHalf.next;
            startSecondHalf.next = current.next;
            current.next = endFirstHalf.next;
            endFirstHalf.next = current;
        }

        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        p1 = A;
        p2 = endFirstHalf.next;
        while(p1 != endFirstHalf) {
            endFirstHalf.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = endFirstHalf.next;
        }

        return A;
    }
}