# Problem Definition

## Description

Implement strStr().

Return the index of the first occurrence of needle in haystack, or **-1** if needle is not part of haystack.

**Example 1:**

```plaintext
Input: haystack = "hello", needle = "ll"
Output: 2
```

**Example 2:**

```plaintext
Input: haystack = "aaaaa", needle = "bba"
Output: -1
```

**Clarification:**

What should we return when `needle` is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when `needle` is an empty string. This is consistent to C's [strstr()](http://www.cplusplus.com/reference/cstring/strstr/) and Java's [indexOf()](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#indexOf(java.lang.String)).

## Notes

1. [LeetCode discussion - Elegant Java solution](https://leetcode.com/problems/implement-strstr/discuss/12807/Elegant-Java-solution)
1. [LeetCode discussion - Accepted KMP solution in java for reference](https://leetcode.com/problems/implement-strstr/discuss/12886/Accepted-KMP-solution-in-java-for-reference)