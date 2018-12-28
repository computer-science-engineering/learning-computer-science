package LeetCode.src.Explore.Interview.GoogleInterview.TreesAndGraphs.ValidateBinarySearchTree.Java;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        int[] values = {
            2,
            1, 3};
        TreeNode root = TreeNode.fromArray(values);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        if(root==null) {
            return true;
        }
        
        long min=Long.MIN_VALUE;
        
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur=root;
        while(cur!=null || !stack.isEmpty()) {
            if(cur!=null) {
                stack.push(cur);
                cur=cur.left;
            } else {
                TreeNode top = stack.pop();
                if(top.val<=min) {
                    return false;
                }
                min=top.val;
                cur=top.right;
            }
        }
        
        return true;
    }
}