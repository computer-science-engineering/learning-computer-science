package EducativeIo.Courses.GrokkingTheCodingInterview.Ch08_TreeBreadthFirstSearch.PC3_TreeBoundary.Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(9);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(15);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(6);
        List<TreeNode> result = findBoundary(root);
        for (TreeNode node : result) {
            System.out.print(node.val + " ");
        }
    }

    public static List<TreeNode> findBoundary(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<TreeNode> leftView = new ArrayList<>();
        List<TreeNode> rightView = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left == null && currentNode.right == null) { // skip leaf nodes
                    continue;
                } else if (i == 0) { // if it is the first node of this level, add it to the
                                     // leftView
                    leftView.add(currentNode);
                } else if (i == levelSize - 1) { // if it is the last node of this level, add it to
                                                 // the rightView
                                                 // because of ant-clockwise direction, we need to
                                                 // populate rightView in the
                                                 // reverse direction
                    rightView.add(0, currentNode);
                }

                // insert the children of current node in the queue
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }

        return new ArrayList<TreeNode>() {
            /**
            *
            */
            private static final long serialVersionUID = 1L;

            {
                addAll(leftView);
                addAll(findLeavesDFS(root));
                addAll(rightView);
            }
        };
    }

    private static List<TreeNode> findLeavesDFS(TreeNode root) {
        List<TreeNode> leaves = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            if (currentNode.left == null && currentNode.right == null) {
                leaves.add(currentNode);
            }

            // insert the children of current node in the stack
            // add the right child first, this way left child will be at the top and processed first
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
        return leaves;
    }
}
