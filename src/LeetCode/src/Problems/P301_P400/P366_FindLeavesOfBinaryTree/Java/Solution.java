package LeetCode.src.Problems.P301_P400.P366_FindLeavesOfBinaryTree.Java;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] values = {
            1,
            2, 3,
            4, 5, -1, -1};
        TreeNode root = TreeNode.fromArray(values);
        List<List<Integer>> result = findLeaves(root);
        for (List<Integer> item : result) {
            System.out.println(item);
        }
    }

    public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leavesList = new ArrayList<List<Integer>>();
        List<Integer> leaves = new ArrayList<Integer>();
        
        while(root != null) {
            if(isLeaf(root, leaves)) {
                root = null;
            }
            leavesList.add(leaves);
            leaves = new ArrayList<Integer>();
        }
        return leavesList;
    }
    
    public static boolean isLeaf(TreeNode node, List<Integer> leaves) {        
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return true;
        }
        
        if (node.left != null) {
             if(isLeaf(node.left, leaves))  {
                node.left = null;
             }
        }
        
        if (node.right != null) {
             if(isLeaf(node.right, leaves)) {
                node.right = null;
             }
        }
        
        return false;
    }
}