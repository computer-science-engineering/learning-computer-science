package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.Trees.BinaryTreeLevelOrderTraversal.Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[] values = {
            1,
            2, 2,
            3, 4, 4, 3};
        TreeNode root = TreeNode.fromArray(values);
        List<List<Integer>> result = levelOrder(root);
        System.out.println(result);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
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
}