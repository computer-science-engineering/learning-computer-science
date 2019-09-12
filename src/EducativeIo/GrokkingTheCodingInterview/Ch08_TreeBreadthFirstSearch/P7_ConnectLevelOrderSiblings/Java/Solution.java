package EducativeIo.GrokkingTheCodingInterview.Ch08_TreeBreadthFirstSearch.P7_ConnectLevelOrderSiblings.Java;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }

    public static void connect(TreeNode root) {
        // TODO: Write your code here
    }
}
