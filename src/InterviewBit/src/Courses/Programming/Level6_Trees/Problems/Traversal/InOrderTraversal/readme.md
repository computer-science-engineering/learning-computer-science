# Problem Definition

## Description

Given a binary tree, return the inorder traversal of its nodes’ values.

Example: Given binary tree

```text
   1
    \
     2
    /
   3
```

return `[1,3,2]`.

Using recursion is not allowed.

## Notes

1. [YT - Vivekanand Khyade - Binary Tree Traversal](https://www.youtube.com/watch?v=98AGQU0z2wg)
1. [YT - Geeks for Geeks - Inorder Tree Traversal without Recursion](https://www.youtube.com/watch?v=VsxLHGUqAKs)
1. [YT - Tushar Roy - Iterative Inorder Traversal of Binary Tree](https://www.youtube.com/watch?v=nzmtCFNae9k)
1. [GeeksForGeeks post](https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/)
    * Create an empty stack S.
    * Initialize current node as root.
    * Push the current node to S and set current = current->left until current is NULL.
    * If current is NULL and stack is not empty then.
      * Pop the top item from stack.
      * Print the popped item, set current = popped_item->right.
      * Go to step 3.
    * If current is NULL and stack is empty then we are done.