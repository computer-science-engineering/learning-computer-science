package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.RootToLeaf.RootToLeafPathsWithSum.Java;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        int[] values = {
            5,
            4, 8,
            11, -1, 13, 4,
            7, 2, -1, -1, -1, -1, 5, 1};
        TreeNode a = TreeNode.fromArray(values);
        ArrayList<ArrayList<Integer>> result = pathSum(a, 22);
        System.out.println(result);
    }
    
    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> currentPath = new ArrayList<Integer>();
		pathSum(result, currentPath, A, B);
		return result;
    }
    
    private static void pathSum(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> currentPath, TreeNode node, int sum) {
		if (node != null) {
			sum = sum - node.val;
			if (sum == 0 && node.left == null && node.right == null) {
				ArrayList<Integer> pathSum = new ArrayList<Integer>();
				pathSum.addAll(currentPath);
				pathSum.add(node.val);
				result.add(pathSum);
			} else {
				currentPath.add(node.val);
				pathSum(result, currentPath, node.left, sum);
				pathSum(result, currentPath, node.right, sum);
				currentPath.remove(currentPath.size() - 1);
			}
		}
	}
}