package InterviewBit.src.Courses.Programming.Level4_LinkedLists.Problems.ListCycle.ListCycle.Java;

public class Solution {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a4;
        ListNode result = detectCycle(a1);
        System.out.println(result.val);
    }

    public static ListNode detectCycle(ListNode a) {
        if(a == null) {
            return null;
        }
        ListNode walker = a;
        ListNode runner = a;
        boolean hasCycle = false;
        while(runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if(walker == runner) {
                hasCycle = true;
                break;
            }
        }

        if(!hasCycle) {
            return null;
        }        
        else {
            runner = a;
            while(runner != walker) {
                runner = runner.next;
                walker = walker.next;
            }
            return runner;
        }
	}    
}