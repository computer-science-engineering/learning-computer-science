# Problem Definition

## Description

Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

**Note:** If the given node has no in-order successor in the tree, return `null`.

**Example 1:**

```plaintext
Input: root = [2,1,3], p = 1

  2
 / \
1   3

Output: 2
```

**Example 2:**

```plaintext
Input: root = [5,3,6,2,4,null,null,1], p = 6

      5
     / \
    3   6
   / \
  2   4
 /
1

Output: null
```

## Notes

1. [YT - CodeSchool - Inorder Successor in a binary search tree](https://www.youtube.com/watch?v=5cPbNCrdotA)
1. [CodeSchool C++ code](https://gist.github.com/mycodeschool/6515e1ec66482faf9d79)
1. [YT - Vivekanand Khyade - Algorithm Every Day - INORDER SUCCESSOR in binary search tree](https://www.youtube.com/watch?v=JdmAYw5h3G8)
1. [ProgramCreek](https://www.programcreek.com/2014/05/leetcode-inorder-successor-in-bst-java/)
1. [Geeks for Geeks - Inorder Successor in Binary Search Tree](https://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/)
1. [LeetCode discussion - Share my Java recursive solution](https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/344/discuss/72653/Share-my-Java-recursive-solution)

    **Successor**

    ```java
    public TreeNode successor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val <= p.val) {
            return successor(root.right, p);
        } else {
            TreeNode left = successor(root.left, p);
            return (left != null) ? left : root;
        }
    }
    ```

    **Predecessor**

    ```java
        public TreeNode predecessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val >= p.val) {
            return predecessor(root.left, p);
        } else {
            TreeNode right = predecessor(root.right, p);
            return (right != null) ? right : root;
        }
    }
    ```

1. [LeetCode discussion - Iterative & Recursive Java Solution with Detailed Explanation](https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/344/discuss/72700/Iterative-and-Recursive-Java-Solution-with-Detailed-Explanation)