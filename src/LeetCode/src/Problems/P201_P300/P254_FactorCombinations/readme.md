# Problem Definition

## Description

Numbers can be regarded as product of its factors. For example,

```plaintext
8 = 2 x 2 x 2;
  = 2 x 4.
```

Write a function that takes an integer n and return all possible combinations of its factors.

**Note:**

1. You may assume that n is always positive.
2. Factors should be greater than 1 and less than n.

**Example 1:**

```plaintext
Input: 1
Output: []
```

**Example 2:**

```plaintext
Input: 37
Output:[]
```

**Example 3:**

```plaintext
Input: 12
Output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
```

**Example 4:**

```plaintext
Input: 32
Output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]
```

## Notes

1. [LeetCode discussion - My Recursive DFS Java Solution](https://leetcode.com/problems/factor-combinations/discuss/68040/My-Recursive-DFS-Java-Solution)