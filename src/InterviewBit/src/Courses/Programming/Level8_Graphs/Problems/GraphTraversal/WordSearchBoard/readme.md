# Problem Definition

## Description

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where `"adjacent"` cells are those horizontally or vertically neighboring. The cell itself does not count as an adjacent cell. The same letter cell may be used more than once.

**Example:**

Given board =

```plaintext
[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
```

```plaintext
word = "ABCCED", -> returns 1,
word = "SEE", -> returns 1,
word = "ABCB", -> returns 1,
word = "ABFSAB" -> returns 1
word = "ABCD" -> returns 0
```

Note that 1 corresponds to true, and 0 corresponds to false.

## Notes

1. [ProgramCreek - LeetCode – Word Search (Java)](https://www.programcreek.com/2014/06/leetcode-word-search-java/)
1. [LeetCode discussion - Accepted very short Java solution. No additional space.](https://leetcode.com/problems/word-search/discuss/27658/Accepted-very-short-Java-solution.-No-additional-space.)