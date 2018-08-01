package LeetCode.src.Problems.P101_P200.P156_BinaryTreeUpsideDown.Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[] values = {
            1,
            2, 3,
            4, 5, -1, -1};
        TreeNode root = TreeNode.fromArray(values);
        TreeNode result = upsideDownBinaryTree(root);
        ArrayList<ArrayList<Integer>> resultList = levelOrder(result);
        for (ArrayList<Integer> list : resultList) {
            System.out.println(list);
        }
    }

    public static TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null) {
            return root;
        }
        
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;   // node 2 left children
        root.left.right = root;        // node 2 right children
        root.left = null;
        root.right = null;
        return newRoot;
    }

    public static TreeNode upsideDownBinaryTree_iterative(TreeNode root) {
        TreeNode current = root;
        TreeNode next = null;
        TreeNode temp = null;
        TreeNode prev = null;
        
        while(current != null) {
            next = current.left;
            
            // swapping nodes now, need temp to keep the previous right child
            current.left = temp;
            temp = current.right;
            current.right = prev;
            
            prev = current;
            current = next;
        }
        return prev;
    }

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
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