package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.LinkedListTree.FlattenBinaryTreeToLinkedList.Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[] values = {
            1,
            2, 5,
            3, 4, -1, 6};
        TreeNode a = TreeNode.fromArray(values);
        TreeNode result = flatten(a);
        ArrayList<Integer> resultArray = levelOrder(result);
        System.out.println(resultArray);
    }
    
    public static TreeNode flatten(TreeNode a) {
        if (a == null) {
            return null;
        }
        
        TreeNode left = a.left;
        TreeNode right = a.right;
        
        a.left = null;
        
        flatten(left);
        flatten(right);
        
        a.right = left;
        TreeNode cur = a;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = right;

        return a;
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