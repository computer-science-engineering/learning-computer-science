package InterviewBit.src.Courses.Programming.Level6_HeapsAndMaps.Problems.Heap.MergeKSortedLists.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(10);
        ListNode a3 = new ListNode(20);
        a1.next = a2;
        a2.next = a3;
        ListNode b1 = new ListNode(4);
        ListNode b2 = new ListNode(11);
        ListNode b3 = new ListNode(13);
        b1.next = b2;
        b2.next = b3;
        ListNode c1 = new ListNode(3);
        ListNode c2 = new ListNode(8);
        ListNode c3 = new ListNode(9);
        c1.next = c2;
        c2.next = c3;
        ArrayList<ListNode> input = new ArrayList<ListNode>(Arrays.asList(a1, b1, c1));
        ListNode result = mergeKLists(input);
        while(result.next != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
        System.out.print(result.val);     
    }
    
    public static ListNode mergeKLists(ArrayList<ListNode> a) {
        if(a.size()==0) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode pre = head;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(
            new Comparator<ListNode>() {
                public int compare(ListNode n1, ListNode n2) {
                    if(n1.val > n2.val) return 1;
                    if(n1.val == n2.val) return 0;
                    return -1;
                }
            });
        for(ListNode node:a) {
            if(node != null) {
                q.add(node);
            }
        }
        while(!q.isEmpty()) {
            ListNode temp = q.remove();
            pre.next = temp;
            pre = temp;
            if(temp.next != null) {
                q.add(temp.next);
            }
        }
        return head.next;
	}
}