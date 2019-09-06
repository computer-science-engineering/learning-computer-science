# Problem Definition

## Description

Given `A`, how many structurally unique BST's (binary search trees) that store values `1...A`?

**Example:**

Given `A = 3`, there are a total of 5 unique BST's.

```plaintext
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
```

## Notes

1. [ProgramCreek - LeetCode – Unique Binary Search Trees II (Java)](https://www.programcreek.com/2014/05/leetcode-unique-binary-search-trees-ii-java/)

    This problem can be solved by recursively forming left and right sub-trees. The different combinations of left and right sub-trees form the set of all unique binary search trees.

1. [LeetCode discussion - Java Solution with DP](https://leetcode.com/problems/unique-binary-search-trees-ii/discuss/31493/Java-Solution-with-DP)
1. [YT Video - IDeserve - Total number of unique binary search trees with values 1 to n](https://www.youtube.com/watch?v=JrTKVvYhT_k)