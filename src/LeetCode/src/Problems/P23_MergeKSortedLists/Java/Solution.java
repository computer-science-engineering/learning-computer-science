package LeetCode.src.Problems.P23_MergeKSortedLists.Java;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;
        ListNode c1 = new ListNode(2);
        ListNode c2 = new ListNode(6);
        c1.next = c2;
        ListNode[] lists = {a1, b1, c1};
        ListNode result = mergeKLists(lists);
        while(result.next != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
        System.out.print(result.val);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) {
                    return -1;
                }
                else if (o1.val == o2.val) {
                    return 0;
                }
                else {
                    return 1;
                }
            }
        });
        
        ListNode dummyHead = new ListNode(0);
        ListNode dummy = dummyHead;
        
        for (ListNode node:lists) {
            if (node != null) {
                queue.add(node);
            }
        }
            
        while (!queue.isEmpty()) {
            dummy.next = queue.poll();
            dummy = dummy.next;
            
            if (dummy.next != null) {
                queue.add(dummy.next);
            }
        }
        return dummyHead.next;
    }
}