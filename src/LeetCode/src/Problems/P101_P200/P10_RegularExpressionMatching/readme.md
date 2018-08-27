# Problem Definition

## Description

Given an input string (`s`) and a pattern (`p`), implement regular expression matching with support for `'.'` and `'*'`.

```text
'.' Matches any single character.
'*' Matches zero or more of the preceding element.
```

The matching should cover the entire input string (not partial).

**Note:**

* `s` could be empty and contains only lowercase letters `a-z`.
* `p` could be empty and contains only lowercase letters `a-z`, and characters like `.` or `*`.

**Example 1:**

```text
Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the **entire** string "aa".
```

**Example 2:**

```text
Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
```

**Example 3:**

```text
Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
```

**Example 4:**

```text
Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
```

**Example 5:**

```text
Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
```

## Notes

1. [ProgramCreek - LeetCode – Regular Expression Matching in Java](https://www.programcreek.com/2012/12/leetcode-regular-expression-matching-in-java/)
1. [Geeks for Geeks - Wildcard Pattern Matching](https://www.geeksforgeeks.org/wildcard-pattern-matching/)
1. [LeetCode discussion - Easy DP Java Solution with detailed Explanation](https://leetcode.com/problems/regular-expression-matching/discuss/5651/Easy-DP-Java-Solution-with-detailed-Explanation)
1. [LeetCode article](https://leetcode.com/articles/regular-expression-matching/)