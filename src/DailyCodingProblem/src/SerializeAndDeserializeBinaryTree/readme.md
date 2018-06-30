# Problem Definition

## Description

Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

For example, given the following Node class

```python
class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
```

The following test should pass:

```python
node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'
```

## Notes

1. [Geeks for Geeks - Serialize and Deserialize a Binary Tree](https://www.geeksforgeeks.org/serialize-deserialize-binary-tree/)
1. [LeetCode discussion - Easy to understand Java Solution](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74253/Easy-to-understand-Java-Solution)
1. [ProgramCreek - Serialize and Deserialize a Binary Tree](https://www.programcreek.com/2014/05/leetcode-serialize-and-deserialize-binary-tree-java/)