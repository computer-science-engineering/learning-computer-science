package EducativeIo.Courses.GrokkingTheCodingInterview.Ch08_TreeBreadthFirstSearch.PC1_ConnectAllLevelOrderSiblings.Java;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    TreeNode(int x) {
        val = x;
        left = right = next = null;
    }

    // tree traversal using 'next' pointer
    public void printTree() {
        TreeNode current = this;
        System.out.print("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    // tree traversal using 'next' pointer
    public List<Integer> getTree() {
        List<Integer> result = new ArrayList<>();
        TreeNode current = this;
        System.out.print("Traversal using 'next' pointer: ");
        while (current != null) {
            result.add(current.val);
            current = current.next;
        }
        return result;
    }

    public static TreeNode fromArray(int[] nodeValues) {
        TreeNode root = null;

        if (nodeValues.length > 0) {
            List<TreeNode> nodes = new ArrayList<TreeNode>();

            for (int i = 0; i < nodeValues.length; i++) {
                TreeNode node = null;

                int nodeVal = nodeValues[i];
                if (nodeVal != -1) {
                    node = new TreeNode(nodeVal);

                    if (i > 0) {
                        int parent = i / 2;

                        boolean left = (i % 2) > 0;

                        if (left) {
                            TreeNode parentNode = nodes.get(parent);
                            parentNode.left = node;
                        } else {
                            parent -= 1;
                            TreeNode parentNode = nodes.get(parent);
                            parentNode.right = node;
                        }
                    }
                }

                nodes.add(node);
            }

            root = nodes.get(0);
        }

        return root;
    }
}
