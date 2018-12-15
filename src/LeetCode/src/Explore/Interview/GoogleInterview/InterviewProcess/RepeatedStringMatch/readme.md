# Problem Definition

## Description

Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

**Note:**

The length of `A` and `B` will be between 1 and 10000.

## Notes

1. [LeetCode discussion - Java Solution - Just keep building (OJ Missing Test Cases)](https://leetcode.com/explore/interview/card/google/67/sql-2/469/discuss/108086/Java-Solution-Just-keep-building-(OJ-Missing-Test-Cases))