package LeetCode.src.Problems.P201_P300.P297_SerializeAndDeserializeBinaryTree.Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[] values = {
            5,
            4, 8,
            11, -1, 13, 4,
            7, 2, -1, -1, -1, -1, 5, 1};
        TreeNode a = TreeNode.fromArray(values);
        Codec codec = new Codec();
        String serializedString = codec.serialize(a);
        TreeNode deserializedTreeNode = codec.deserialize(serializedString);
        ArrayList<ArrayList<Integer>> deserializedValues = levelOrder(deserializedTreeNode);
        System.out.println(serializedString);
        System.out.println(deserializedValues);
    }

    public static String serialize(TreeNode root) {
        Codec codec = new Codec();
        return codec.serialize(root);
    }

    public static TreeNode deserialize(String data) {
        Codec codec = new Codec();
        return codec.deserialize(data);
    }

    private static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        ArrayList<Integer> tempResult = new ArrayList<Integer>();
		while(!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            if (tempNode == null) {
                result.add(new ArrayList<Integer>(tempResult));
                if (queue.isEmpty()) {
                    break;
                }
                tempResult.clear();
                queue.add(null);
            }
            else {
                tempResult.add(tempNode.val);
                if(tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if(tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }			
        }
        return result;
    }
}