# Problem Definition

## Description

Given a set of words **(without duplicates)**, find all word squares you can build from them.

A sequence of words forms a valid word square if the *k*th row and column read the exact same string, where 0 ≤ *k* < max(numRows, numColumns).

For example, the word sequence `["ball","area","lead","lady"]` forms a word square because each word reads the same both horizontally and vertically.

```plaintext
b a l l
a r e a
l e a d
l a d y
```

**Note:**

1. There are at least 1 and at most 1000 words.
2. All words will have the exact same length.
3. Word length is at least 1 and at most 5.
4. Each word contains only lowercase English alphabet a-z.

**Example 1:**

```plaintext
Input:
["area","lead","wall","lady","ball"]

Output:
[
  [ "wall",
    "area",
    "lead",
    "lady"
  ],
  [ "ball",
    "area",
    "lead",
    "lady"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
```

**Example 2:**

```plaintext
Input:
["abat","baba","atan","atal"]

Output:
[
  [ "baba",
    "abat",
    "baba",
    "atan"
  ],
  [ "baba",
    "abat",
    "baba",
    "atal"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
```

## Notes

1. [LeetCode discussion - Explained. My Java solution using Trie [126ms 16/16]](https://leetcode.com/explore/interview/card/google/62/recursion-4/370/discuss/91333/Explained.-My-Java-solution-using-Trie-126ms-1616)
1. [LeetCode discussion - Java DFS+Trie 54 ms, 98% so far](https://leetcode.com/explore/interview/card/google/62/recursion-4/370/discuss/91354/Java-DFS+Trie-54-ms-98-so-far)