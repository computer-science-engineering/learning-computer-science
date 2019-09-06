# Problem Definition

## Description

Given a string S, find the number of different non-empty palindromic subsequences in S, and **return that number modulo** `10^9 + 7`.

A subsequence of a string S is obtained by deleting 0 or more characters from S.

A sequence is palindromic if it is equal to the sequence reversed.

Two sequences `A_1, A_2, ...` and `B_1, B_2, ...` are different if there is some i for which `A_i != B_i`.

**Example 1:**

```plaintext
Input:
S = 'bccb'
Output: 6
Explanation:
The 6 different non-empty palindromic subsequences are 'b', 'c', 'bb', 'cc', 'bcb', 'bccb'.
Note that 'bcb' is counted only once, even though it occurs twice.
```

**Example 2:**

```plaintext
Input:
S = 'abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba'
Output: 104860361
Explanation:
There are 3104860382 different non-empty palindromic subsequences, which is 104860361 modulo 10^9 + 7.
```

**Note:**

* The length of `S` will be in the range `[1, 1000]`.
* Each character `S[i]` will be in the set `{'a', 'b', 'c', 'd'}`.

## Notes

1. [LeetCode discussion - Accepted Java Solution using memoization](https://leetcode.com/problems/count-different-palindromic-subsequences/discuss/109509/Accepted-Java-Solution-using-memoization)
1. [LeetCode article](https://leetcode.com/articles/count-different-palindromic-subsequences/)
1. [YT Video - Vivekanand Khyade - Longest Palindromic Subsequence and it's Length (ALGORITHM -DYNAMIC PROGRAMMING)](https://www.youtube.com/watch?v=yZWmS6CXbQc)
1. [YT Video - Tushar Roy - Longest Palindromic Substring Manacher's Algorithm](https://www.youtube.com/watch?v=V-sEwsca1ak)
1. [YT Video - Tushar Roy - Longest Palindromic Subsequence](https://www.youtube.com/watch?v=_nCsPn7_OgI)