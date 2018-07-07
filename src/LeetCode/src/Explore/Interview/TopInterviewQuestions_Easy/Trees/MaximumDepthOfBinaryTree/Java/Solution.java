package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.Trees.MaximumDepthOfBinaryTree.Java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] values = {
            5,
            4, 8,
            11, -1, 13, 4,
            7, 2, -1, -1, -1, -1, 5, 1};
        TreeNode root = TreeNode.fromArray(values);
        System.out.println(maxDepth(root));
    }

    // recursive 
    public static int maxDepth(TreeNode root) {
        if(root==null) {
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    public static int maxDepth_Iterative_dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int max = 0;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int temp = value.pop();
            max = Math.max(temp, max);
            if(node.left != null) {
                stack.push(node.left);
                value.push(temp+1);
            }
            if(node.right != null) {
                stack.push(node.right);
                value.push(temp+1);
            }
        }
        return max;
    }

    public static int maxDepth_Iterative_bfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;
    }
}