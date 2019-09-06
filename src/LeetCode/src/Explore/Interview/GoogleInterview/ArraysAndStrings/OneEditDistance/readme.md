# Problem Definition

## Description

Given two strings **s** and **t**, determine if they are both one edit distance apart.

**Note:**

There are 3 possibilities to satisfy one edit distance apart:

Insert a character into **s** to get **t**
Delete a character from **s** to get **t**
Replace a character of **s** to get **t**

**Example 1:**

```plaintext
Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.
```

**Example 2:**

```plaintext
Input: s = "cab", t = "ad"
Output: false
Explanation: We cannot get t from s by only one step.
```

**Example 3:**

```plaintext
Input: s = "1203", t = "1213"
Output: true
Explanation: We can replace '0' with '1' to get t.
```

## Notes

1. [LeetCode discussion - Easy understood Java solution](https://leetcode.com/explore/interview/card/google/59/array-and-strings/398/discuss/50101/Easy-understood-Java-solution)
1. [LeetCode discussion - My CLEAR JAVA solution with explanation](https://leetcode.com/explore/interview/card/google/59/array-and-strings/398/discuss/50098/My-CLEAR-JAVA-solution-with-explanation)
1. [LeetCode discussion - Java/Python two pointer solution](https://leetcode.com/explore/interview/card/google/59/array-and-strings/398/discuss/50190/JavaPython-two-pointer-solution)