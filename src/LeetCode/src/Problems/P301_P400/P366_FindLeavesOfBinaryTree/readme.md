# Problem Definition

## Description

Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

**Example:**

Given binary tree

```plaintext
          1
         / \
        2   3
       / \
      4   5
```

Returns `[4, 5, 3], [2], [1]`.

**Explanation:**

1. Removing the leaves `[4, 5, 3]` would result in this tree:

```plaintext
          1
         /
        2
```

1. Now removing the leaf `[2]` would result in this tree:

```plaintext
          1
```

1. Now removing the leaf `[1]` would result in the empty tree:

```plaintext
          []
```

Returns `[4, 5, 3], [2], [1]`.

## Notes

1. [LeetCode discussion - 1 ms Easy understand Java Solution](https://leetcode.com/problems/find-leaves-of-binary-tree/discuss/83773/1-ms-Easy-understand-Java-Solution)