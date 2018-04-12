package InterviewBit.src.Courses.Programming.Level8_Graphs.Problems.GraphAdHoc.ConvertSortedListToBinarySearchTree.Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;

        TreeNode result = sortedListToBST(a);
        ArrayList<Integer> resultArrayList = levelOrder(result);
        System.out.println(resultArrayList);
    }

    static ListNode h;

    public static TreeNode sortedListToBST(ListNode a) {
        if (a == null) {
            return null;
        }
 
		h = a;
		int len = getLength(a);
		return sortedListToBST(0, len - 1);
	}
 
	// get list length
	private static int getLength(ListNode head) {
		int len = 0;
		ListNode p = head;
 
		while (p != null) {
			len++;
			p = p.next;
		}
		return len;
	}
 
	// build tree bottom-up
	private static TreeNode sortedListToBST(int start, int end) {
		if (start > end) {
            return null;
        }
 
		// mid
		int mid = (start + end) / 2;
 
		TreeNode left = sortedListToBST(start, mid - 1);
		TreeNode root = new TreeNode(h.val);
		h = h.next;
		TreeNode right = sortedListToBST(mid + 1, end);
 
		root.left = left;
		root.right = right;
 
		return root;
    }
    
    public static ArrayList<Integer> levelOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode tempNode = queue.poll();
			result.add(tempNode.val);
			if(tempNode.left != null) {
                queue.add(tempNode.left);
            }
			if(tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
        return result;
    }    
}