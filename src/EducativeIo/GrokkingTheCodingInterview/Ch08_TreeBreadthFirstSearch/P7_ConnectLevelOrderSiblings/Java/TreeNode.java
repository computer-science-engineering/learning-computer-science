package EducativeIo.GrokkingTheCodingInterview.Ch08_TreeBreadthFirstSearch.P7_ConnectLevelOrderSiblings.Java;

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

    // level order traversal using 'next' pointer
    void printLevelOrder() {
        TreeNode nextLevelRoot = this;
        while (nextLevelRoot != null) {
            TreeNode current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null) {
                        nextLevelRoot = current.left;
                    } else if (current.right != null) {
                        nextLevelRoot = current.right;
                    }
                }
                current = current.next;
            }
            System.out.println();
        }
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
