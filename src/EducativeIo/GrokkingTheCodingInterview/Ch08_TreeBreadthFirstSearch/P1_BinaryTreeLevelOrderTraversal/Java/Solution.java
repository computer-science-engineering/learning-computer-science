package EducativeIo.GrokkingTheCodingInterview.Ch08_TreeBreadthFirstSearch.P1_BinaryTreeLevelOrderTraversal.Java;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] values = {12, 7, 1, 9, -1, 10, 5};
        TreeNode root = TreeNode.fromArray(values);
        List<List<Integer>> result = traverse(root);
        System.out.println("Level order traversal: " + result);
    }

    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // TODO: Write your code here
        return result;
    }
}
