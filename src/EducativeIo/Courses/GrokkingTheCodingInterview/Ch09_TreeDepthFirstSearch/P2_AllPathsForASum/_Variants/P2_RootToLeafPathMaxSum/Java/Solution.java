package EducativeIo.Courses.GrokkingTheCodingInterview.Ch09_TreeDepthFirstSearch.P2_AllPathsForASum._Variants.P2_RootToLeafPathMaxSum.Java;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static int maxSum = Integer.MIN_VALUE;

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
        List<List<Integer>> maxPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<Integer>();
        int runningSum = 0;
        findPathsRecursive(root, runningSum, currentPath, maxPaths);
        System.out.println(maxPaths);
        return maxPaths.isEmpty() ? null : maxPaths.get(maxPaths.size() - 1);
    }

    private static void findPathsRecursive(TreeNode currentNode, int runningSum,
            List<Integer> currentPath, List<List<Integer>> maxPaths) {
        if (currentNode == null) {
            return;
        }

        // add the current node to the path
        currentPath.add(currentNode.val);
        runningSum += currentNode.val;

        if (currentNode.left == null && currentNode.right == null) {
            if (runningSum >= maxSum) {
                maxSum = runningSum;
                runningSum = 0;
                maxPaths.add(new ArrayList<Integer>(currentPath));
            }
        } else {
            // traverse the left sub-tree
            findPathsRecursive(currentNode.left, runningSum, currentPath, maxPaths);
            // traverse the right sub-tree
            findPathsRecursive(currentNode.right, runningSum, currentPath, maxPaths);
        }

        // remove the current node from the path to backtrack,
        // we need to remove the current node while we are going up the recursive call stack.
        currentPath.remove(currentPath.size() - 1);
    }
}
