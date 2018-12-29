package LeetCode.src.Explore.Interview.GoogleInterview.TreesAndGraphs.ClosestBinarySearchTreeValue.Java;

public class Solution {
    public static void main(String[] args) {
        int[] values = {
            4,
            2, 5,
            1, 3, -1, -1};
        TreeNode root = TreeNode.fromArray(values);
        double target = 3.714286;
        System.out.println(closestValue(root, target));
    }

    public static int closestValue(TreeNode root, double target) {
        int ret = root.val;   
        while(root != null){
            if(Math.abs(target - root.val) < Math.abs(target - ret)) {
                ret = root.val;
            }      
            root = root.val > target? root.left: root.right;
        }     
        return ret;
    }
}