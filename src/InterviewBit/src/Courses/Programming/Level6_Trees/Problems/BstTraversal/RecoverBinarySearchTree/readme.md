# Problem Definition

## Description

Two elements of a binary search tree (BST) are swapped by mistake. Tell us the 2 values swapping which the tree will be restored.

Note: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

Example:

```plaintext
Input:
         1
        / \
       2   3

Output:
       [1, 2]

Explanation: Swapping 1 and 2 will change the BST to be

         2
        / \
       1   3

which is a valid BST
```

## Notes

1. [ProgramCreek](https://www.programcreek.com/2014/05/leetcode-recover-binary-search-tree-java/): Inorder traversal will return values in an increasing order. So if an element is less than its previous element, the previous element is a swapped node.
1. [LeetCode discussion - Detail Explain about How Morris Traversal Finds two Incorrect Pointer](https://leetcode.com/problems/recover-binary-search-tree/discuss/32559/Detail-Explain-about-How-Morris-Traversal-Finds-two-Incorrect-Pointer)
1. [LeetCode discussion - No Fancy Algorithm, just Simple and Powerful In-Order Traversal](https://leetcode.com/problems/recover-binary-search-tree/discuss/32535/No-Fancy-Algorithm-just-Simple-and-Powerful-In-Order-Traversal)
1. [Morris traversal utilization](http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html)