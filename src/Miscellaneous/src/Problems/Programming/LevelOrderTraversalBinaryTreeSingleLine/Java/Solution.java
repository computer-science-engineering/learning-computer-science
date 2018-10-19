package Miscellaneous.src.Problems.Programming.LevelOrderTraversalBinaryTreeSingleLine.Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(40);
		TreeNode node20 = new TreeNode(20);
		TreeNode node10 = new TreeNode(10);
		TreeNode node30 = new TreeNode(30);
		TreeNode node60 = new TreeNode(60);
		TreeNode node50 = new TreeNode(50);
		TreeNode node70 = new TreeNode(70);
 
		rootNode.left = node20;
		rootNode.right = node60;
 
		node20.left = node10;
		node20.right = node30;
 
		node60.left = node50;
        node60.right = node70;
        
        ArrayList<Integer> result = levelOrder(rootNode);
        for (Integer item : result) {
            System.out.print(item + " ");
        }
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