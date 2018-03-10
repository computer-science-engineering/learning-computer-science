# Problem Definition

## Description

Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)

The solution set must not contain duplicate quadruplets.

Example:

Given array S = {1, 0, -1, 0, -2, 2}, and target = 0

A solution set is:

```text
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
    (-1,  0, 0, 1)
```

Also make sure that the solution set is lexicographically sorted.

Solution[i] < Solution[j] iff Solution[i][0] < Solution[j][0] OR (Solution[i][0] == Solution[j][0] AND ... Solution[i][k] < Solution[j][k])

## Notes

1. [GeeksForGeeks](https://www.geeksforgeeks.org/find-four-elements-that-sum-to-a-given-value-set-2/)
1. [LifeInCode](http://www.lifeincode.net/programming/leetcode-two-sum-3-sum-3-sum-closest-and-4-sum-java/)
1. [LeetCode discussion](https://leetcode.com/problems/4sum/discuss/8547/7ms-java-code-win-over-100)
1. [LeetCode discussion](https://leetcode.com/problems/4sum/discuss/8609/My-solution-generalized-for-kSums-in-JAVA)
1. [YouTube - Tushar Roy - DP approach](https://www.youtube.com/watch?v=s6FhG--P7z0)