package InterviewBit.src.Courses.Programming.Level8_Graphs.Problems.Bfs.LevelOrder.Java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[] values = {
            3,
            9, 20,
            -1, -1, 15, 7};
        TreeNode A = TreeNode.fromArray(values);
        ArrayList<ArrayList<Integer>> result = levelOrder(A);
        System.out.println(result);
        ArrayList<ArrayList<Integer>> result_Editorial = levelOrder_Editorial(A);
        System.out.println(result_Editorial);
    }
    
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (A == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(A);
        queue.add(null);
        ArrayList<Integer> tempResult = new ArrayList<Integer>();
		while(!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            if (tempNode == null) {
                result.add(new ArrayList<Integer>(tempResult));
                if (queue.isEmpty()) {
                    break;
                }
                tempResult.clear();
                queue.add(null);
            }
            else {
                tempResult.add(tempNode.val);
                if(tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if(tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }			
        }
        return result;
    }

    public static ArrayList<ArrayList<Integer>> levelOrder_Editorial(TreeNode a) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    if (a == null)  return res;
	    
	    Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
	    queue.offer(a);
	    
	    while (!queue.isEmpty()) {
	        int n = queue.size();
	        ArrayList<Integer> al = new ArrayList<Integer>();
	        for (int i = 0; i < n; i++) {
	            a = queue.poll();
	            al.add(a.val);
	            if (a.left != null)     queue.add(a.left);
	            if (a.right != null)    queue.add(a.right);
	        }
	        res.add(al);
	    }
	    
	    return res;
	}
}