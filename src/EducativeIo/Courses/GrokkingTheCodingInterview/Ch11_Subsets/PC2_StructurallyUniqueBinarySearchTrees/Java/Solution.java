package EducativeIo.Courses.GrokkingTheCodingInterview.Ch11_Subsets.PC2_StructurallyUniqueBinarySearchTrees.Java;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<TreeNode> result = findUniqueTrees(2);
        System.out.print("Total trees: " + result.size());
    }

    public static List<TreeNode> findUniqueTrees(int n) {
        if (n <= 0) {
            return new ArrayList<TreeNode>();
        }
        return findUniqueTreesRecursive(1, n);
    }

    public static List<TreeNode> findUniqueTreesRecursive(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        // base condition, return 'null' for an empty sub-tree
        // consider n=1, in this case we will have start=end=1, this means we should have only one
        // tree
        // we will have two recursive calls, findUniqueTreesRecursive(1, 0) & (2, 1)
        // both of these should return 'null' for the left and the right child
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            // making 'i' root of the tree
            List<TreeNode> leftSubtrees = findUniqueTreesRecursive(start, i - 1);
            List<TreeNode> rightSubtrees = findUniqueTreesRecursive(i + 1, end);
            for (TreeNode leftTree : leftSubtrees) {
                for (TreeNode rightTree : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
