# Problem Definition

## Description

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

* The left subtree of a node contains only nodes with keys **less than** the node's key.
* The right subtree of a node contains only nodes with keys **greater than** the node's key.
* Both the left and right sub-trees must also be binary search trees.

**Example 1:**

```text
Input:
    2
   / \
  1   3
Output: true
```

**Example 2:**

```text
    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
```

## Notes

1. [LeetCode solution](https://leetcode.com/problems/validate-binary-search-tree/solution/)
1. [LeetCode discussion - My simple Java solution in 3 lines](https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/437/discuss/32109/My-simple-Java-solution-in-3-lines)
1. [LeetCode discussion - Learn one iterative inorder traversal, apply it to multiple tree questions (Java Solution)](https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/437/discuss/32112/Learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-(Java-Solution))

    I will show you all how to tackle various tree questions using iterative inorder traversal. First one is the standard iterative inorder traversal using stack. Hope everyone agrees with this solution.

    Question : [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)

    ```java
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
    ```

    Now, we can use this structure to find the Kth smallest element in BST.

    Question : [Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)

    ```java
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            } 
            root = stack.pop();
            if(--k == 0) break;
            root = root.right;
        }
        return root.val;
    }
    ```

    We can also use this structure to solve BST validation question.

    Question : [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)

    ```java
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
    ```