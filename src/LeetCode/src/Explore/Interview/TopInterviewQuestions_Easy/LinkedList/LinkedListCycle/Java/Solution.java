package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.LinkedList.LinkedListCycle.Java;

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
        System.out.println(hasCycle(a1));
    }

    public static boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode walker = head;
        ListNode runner = head;
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
            return false;
        }        
        else {
            /*runner = head;
            while(runner != walker) {
                runner = runner.next;
                walker = walker.next;
            }*/
            return true;
        }
    }
}