package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.InPlaceChange.InvertTheBinaryTree.Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b1 = new TreeNode(2);
        TreeNode b2 = new TreeNode(3);
        TreeNode c1 = new TreeNode(4);
        TreeNode c2 = new TreeNode(5);
        TreeNode c3 = new TreeNode(6);
        TreeNode c4 = new TreeNode(7);

        a.left = b1;
        a.right = b2;
        b1.left = c1;
        b1.right = c2;
        b2.left = c3;
        b2.right = c4;

        TreeNode result = invertTree(a);
        ArrayList<Integer> resultArray = levelOrder(result);
        for (Integer item : resultArray) {
            System.out.print(item + " ");
        }
    }
    
    public static TreeNode invertTree(TreeNode A) {
        if (A == null) {
            return null;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);

        while(!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
        return A;
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