# Problem Definition

## Description

Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

**Example:**

```text
Input:
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Output: ["eat","oath"]
```

**Note:** You may assume that all inputs are consist of lowercase letters `a-z`.

## Notes

1. [LeetCode discussion - Java 15ms Easiest Solution (100.00%)](https://leetcode.com/explore/interview/card/google/62/recursion-4/462/discuss/59780/Java-15ms-Easiest-Solution-(100.00))