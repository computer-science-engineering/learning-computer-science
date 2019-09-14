package EducativeIo.GrokkingTheCodingInterview.Ch08_TreeBreadthFirstSearch.P7_ConnectLevelOrderSiblings.Java;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }

    public static void connect(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode previousNode = null;
            int levelSize = queue.size();
            // connect all nodes of this level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (previousNode != null) {
                    previousNode.next = currentNode;
                }
                previousNode = currentNode;

                // insert the children of current node in the queue
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
    }
}
