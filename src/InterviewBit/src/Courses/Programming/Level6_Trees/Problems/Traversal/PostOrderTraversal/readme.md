# Problem Definition

## Description

Given a binary tree, return the post-order traversal of its nodes' values.

Example: Given binary tree

```plaintext
   1
    \
     2
    /
   3
```

return `[3,2,1]`.

Using recursion is not allowed.

## Notes

1. [YT - Vivekanand Khyade - Binary Tree Traversal](https://www.youtube.com/watch?v=98AGQU0z2wg)
1. [YT - Tushar Roy - Iterative Postorder traversal of binary tree using one stack](https://www.youtube.com/watch?v=xLQKdq0Ffjg)
1. [GitHub - Tushar Roy](https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/TreeTraversals.java#L98)
1. [Geeks for Geeks post](https://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/)
    * Create an empty stack.
    * Do following while root is not NULL.
        * Push root's right child and then root to stack.
        * Set root as root's left child.
    * Pop an item from stack and set it as root.
        * If the popped item has a right child and the right child is at top of stack, then remove the right child from stack, push the root back and set root as root's right child.
        * Else print root's data and set root as NULL.
    * Repeat steps 2.1 and 2.2 while stack is not empty.