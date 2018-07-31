package LeetCode.src.Problems.P101_P200.P103_BinaryTreeZigzagLevelOrderTraversal.Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] values = {
            5,
            4, 8,
            11, -1, 13, 4,
            7, 2, -1, -1, -1, -1, 5, 1};
        TreeNode a = TreeNode.fromArray(values);
        List<List<Integer>> result = zigzagLevelOrder(a);
        System.out.println(result);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> sol = new ArrayList<>();
        travel(root, sol, 0);
        return sol;
    }

    private static void travel(TreeNode current, List<List<Integer>> sol, int level) {
        if(current == null) {
            return;
        }
        
        // root level
        if(sol.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            sol.add(newLevel);
        }
        
        List<Integer> collection  = sol.get(level);
        if(level % 2 == 0) {
            collection.add(current.val);
        }
        else {
            collection.add(0, current.val);
        }
        
        travel(current.left, sol, level + 1);
        travel(current.right, sol, level + 1);
    }
}