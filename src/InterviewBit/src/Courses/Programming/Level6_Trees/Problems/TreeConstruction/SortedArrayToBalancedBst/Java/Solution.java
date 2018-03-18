package InterviewBit.src.Courses.Programming.Level6_Trees.Problems.TreeConstruction.SortedArrayToBalancedBst.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        TreeNode result = sortedArrayToBST(a);
        System.out.println(result.val);
    }
    
    public static TreeNode sortedArrayToBST(final List<Integer> a) {
        if (a == null || a.size() ==0){
            return null;
        }
        return getTreeNode(a, 0, a.size()-1);
    }
    
    private static TreeNode getTreeNode(List<Integer> nums, int start, int end){
        if (start > end){
            return null;
        }
        int middle = start + (end-start)/2;
        TreeNode n = new TreeNode(nums.get(middle));
        n.left = getTreeNode(nums, start, middle-1);
        n.right = getTreeNode(nums, middle+1, end);
        return n;
    }
}