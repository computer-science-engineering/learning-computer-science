package LeetCode.src.Problems.P501_P600.P515_FindLargestValueInEachTreeRow.Java;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] values = {
            1,
            3, 2,
            5, 3, -1, 9};
        TreeNode root = TreeNode.fromArray(values);
        List<Integer> result = largestValues(root);
        System.out.println(result);
    }

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }

    private static void helper(TreeNode root, List<Integer> res, int d) {
        if(root == null) {
            return;
        }
        //expand list size
        if(d == res.size()) {
            res.add(root.val);
        }
        else {
        //or set value
            res.set(d, Math.max(res.get(d), root.val));
        }
        helper(root.left, res, d+1);
        helper(root.right, res, d+1);
    }
}