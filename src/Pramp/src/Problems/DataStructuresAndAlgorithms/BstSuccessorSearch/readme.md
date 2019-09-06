# Problem Definition

## Description

In a Binary Search Tree (BST), an Inorder Successor of a node is defined as the node with the smallest key greater than the key of the input node (see examples below). Given a node inputNode in a BST, you’re asked to write a function findInOrderSuccessor that returns the Inorder Successor of inputNode. If inputNode has no Inorder Successor, return null.

Explain your solution and analyze its time and space complexities.

**Example:**

```plaintext
    20
   /  \
  9    25
 / \
5   12
    / \
   11  14
```

In the diagram above, for inputNode whose key = 11

Your function would return:

The Inorder Successor node whose key = 12

**Constraints:**

* [time limit] 5000ms
* [input] Node inputNode
* [output] Node

## Notes