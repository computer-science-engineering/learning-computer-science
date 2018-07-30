# Problem Definition

## Description

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

**Example:**

```text
You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
```

**Clarification:** The above format is the same as [how LeetCode serializes a binary tree](https://leetcode.com/faq/#binary-tree). You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

**Note:** Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

## Notes

1. [Geeks for Geeks - Serialize and Deserialize a Binary Tree](https://www.geeksforgeeks.org/serialize-deserialize-binary-tree/)
1. [LeetCode discussion - Easy to understand Java Solution](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74253/Easy-to-understand-Java-Solution)
1. [ProgramCreek - Serialize and Deserialize a Binary Tree](https://www.programcreek.com/2014/05/leetcode-serialize-and-deserialize-binary-tree-java/)