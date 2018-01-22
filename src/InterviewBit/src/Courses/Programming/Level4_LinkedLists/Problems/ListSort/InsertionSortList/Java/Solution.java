package InterviewBit.src.Courses.Programming.Level4_LinkedLists.Problems.ListSort.InsertionSortList.Java;

public class Solution {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;
        ListNode result = insertionSortList(a1);
        while(result.next != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
        System.out.print(result.val);     
    }

    public static ListNode insertionSortList(ListNode A) {
        if( A == null ){
			return A;
		}
		
		ListNode helper = new ListNode(0); // new starter of the sorted list
		ListNode cur = A; // the node will be inserted
		ListNode pre = helper; // insert node between pre and pre.next
		ListNode next = null; // the next node will be inserted
		//not the end of input list
		while( cur != null ){
			next = cur.next;
			//find the right place to insert
			while( pre.next != null && pre.next.val < cur.val ){
				pre = pre.next;
			}
			//insert between pre and pre.next
			cur.next = pre.next;
			pre.next = cur;
			pre = helper;
			cur = next;
		}
		
		return helper.next;
    }    
}