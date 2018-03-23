# Problem Definition

## Description

Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

The first call to next() will return the smallest number in BST. Calling next() again will return the next smallest number in the BST, and so on.

Note: `next()` and `hasNext()` should run in average `O(1)` time and uses `O(h)` memory, where `h` is the height of the tree.
Try to optimize the additional space complexity apart from the amortized time complexity.

Your Solution will be called like this:

```java
Solution i = new Solution(root);
while (i.hasNext()) System.out.print(i.next());
```

## Notes

1. [LeetCode Discussion - Ideal Solution using Stack (Java)](https://leetcode.com/problems/binary-search-tree-iterator/discuss/52526/Ideal-Solution-using-Stack-(Java))