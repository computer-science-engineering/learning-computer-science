# Problem Definition

## Description

Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

**Example:**

```text
Input: [1,2,3,4,5]

    1
   / \
  2   3
 / \
4   5

Output: return the root of the binary tree [4,5,2,#,#,3,1]

   4
  / \
 5   2
    / \
   3   1  
```

**Clarification:**

Confused what `[4,5,2,#,#,3,1]` means? Read more below on how binary tree is serialized on OJ.

The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:

```text
   1
  / \
 2   3
    /
   4
    \
     5
```

The above binary tree is serialized as `[1,2,3,#,#,4,#,#,5]`.

## Notes

1. [LeetCode discussion - Java recursive (O(logn) space) and iterative solutions (O(1) space) with explanation and figure](https://leetcode.com/problems/binary-tree-upside-down/discuss/49406/Java-recursive-(O(logn)-space)-and-iterative-solutions-(O(1)-space)-with-explanation-and-figure)