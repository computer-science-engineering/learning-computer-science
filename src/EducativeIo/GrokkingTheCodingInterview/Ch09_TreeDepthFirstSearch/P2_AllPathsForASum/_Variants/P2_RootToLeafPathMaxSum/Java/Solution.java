package EducativeIo.GrokkingTheCodingInterview.Ch09_TreeDepthFirstSearch.P2_AllPathsForASum._Variants.P2_RootToLeafPathMaxSum.Java;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Integer> result = findPath(root);
        System.out.println("Tree path with max sum " + ": " + result);
    }

    public static List<Integer> findPath(TreeNode root) {
        List<Integer> maxPath = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<Integer>();
        int maxSum = Integer.MIN_VALUE;
        findPathsRecursive(root, maxSum, currentPath, maxPath);
        return maxPath;
    }

    private static void findPathsRecursive(TreeNode currentNode, int maxSum,
            List<Integer> currentPath, List<Integer> maxPath) {
        if (currentNode == null) {
            return;
        }
        System.out.println("here: " + maxSum);

        // add the current node to the path
        currentPath.add(currentNode.val);

        // if the current node is a leaf and its value is equal to sum, save the current path
        if (currentNode.left == null && currentNode.right == null) {
            Integer sum = 0;
            for (Integer item : currentPath) {
                sum += item;
            }
            if (sum >= maxSum) {
                maxSum = sum;
                maxPath = new ArrayList<Integer>(currentPath);
            }
        } else {
            // traverse the left sub-tree
            findPathsRecursive(currentNode.left, maxSum, currentPath, maxPath);
            // traverse the right sub-tree
            findPathsRecursive(currentNode.right, maxSum, currentPath, maxPath);
        }

        // remove the current node from the path to backtrack,
        // we need to remove the current node while we are going up the recursive call stack.
        currentPath.remove(currentPath.size() - 1);
    }
}
