# Problem Definition

## Description

Given a string containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.

**Example 1:**

```plaintext
Input: "()"
Output: true
```

**Example 2:**

```plaintext
Input: "()[]{}"
Output: true
```

**Example 3:**

```plaintext
Input: "(]"
Output: false
```

**Example 4:**

```plaintext
Input: "([)]"
Output: false
```

**Example 5:**

```plaintext
Input: "{[]}"
Output: true
```

## Notes

1. [LeetCode solution](https://leetcode.com/problems/valid-parentheses/solution/)
1. [LeetCode discussion - Short java solution](https://leetcode.com/explore/interview/card/google/59/array-and-strings/467/discuss/9178/Short-java-solution)