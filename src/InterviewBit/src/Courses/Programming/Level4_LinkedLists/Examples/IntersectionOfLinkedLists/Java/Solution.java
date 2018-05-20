package InterviewBit.src.Courses.Programming.Level4_LinkedLists.Examples.IntersectionOfLinkedLists.Java;

public class Solution {
    public static void main(String[] args) {
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
        ListNode result = getIntersectionNode(a1, b1);
        if (result!= null) {
            while(result.next != null) {
                System.out.print(result.val + "->");
                result = result.next;
            }
            System.out.print(result.val);
        }
    }

    public static ListNode getIntersectionNode(ListNode a, ListNode b) {
        //boundary check
        if(a == null || b == null) {
            return null;
        }
        
        ListNode A = a;
        ListNode B = b;
        
        //if a & b have different len, then we will stop the loop after second iteration
        while( A != B) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            A = A == null? b : A.next;
            B = B == null? a : B.next;    

            if (A == a && B == b) {
                return null;
            }
        }
        
        return A;
    }
    
    /*
    public static ListNode getIntersectionNode_attempt1(ListNode a, ListNode b) {
        if(a == null || b == null) {
            return null;
        }

        int lenA = length(a), lenB = length(b);
        // move headA and headB to the same start point
        while (lenA > lenB) {
            a = a.next;
            lenA--;
        }
        while (lenA < lenB) {
            a = b.next;
            lenB--;
        }

        if(a == b) {
            return a;
        }

        // find the intersection until end
        while (a != b) {
            a = a.next;
            b = b.next;
            if(a == null) {
                return null;
            }
        }
        return a;
    }
    
    private static int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }*/
}