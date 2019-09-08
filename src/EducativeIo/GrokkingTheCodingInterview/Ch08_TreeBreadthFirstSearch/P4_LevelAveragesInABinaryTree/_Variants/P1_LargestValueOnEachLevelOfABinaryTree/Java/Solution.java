package EducativeIo.GrokkingTheCodingInterview.Ch08_TreeBreadthFirstSearch.P4_LevelAveragesInABinaryTree._Variants.P1_LargestValueOnEachLevelOfABinaryTree.Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Integer> result = findLevelMaximums(root);
        System.out.print("Level averages are: " + result);
    }

    public static List<Integer> findLevelMaximums(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelMaximum = Integer.MIN_VALUE;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelMaximum = Math.max(levelMaximum, currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(levelMaximum);
        }

        return result;
    }
}
