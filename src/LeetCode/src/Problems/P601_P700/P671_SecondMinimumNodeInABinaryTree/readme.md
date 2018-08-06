# Problem Definition

## Description

Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly `two` or `zero` sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.

Given such a binary tree, you need to output the **second minimum** value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

**Example 1:**

```text
Input:
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
```

**Example 2:**

```text
Input:
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
```

## Notes

1. [LeetCode discussion - Java 4 lines](https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/discuss/107233/Java-4-lines)
1. [LeetCode discussion - Java divide and conquer solution](https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/discuss/107158/Java-divide-and-conquer-solution)
1. [LeetCode article](https://leetcode.com/articles/second-minimum-node-in-a-binary-tree/)