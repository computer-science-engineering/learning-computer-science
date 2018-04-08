# Problem Definition

## Description

Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

**Example:**

Given `s = "aab"`,

Return `1` since the palindrome partitioning `["aa","b"]` could be produced using `1` cut.

## Notes

1. [LeetCode discussion - My solution does not need a table for palindrome, is it right ? It uses only O(n) space.]("https://leetcode.com/problems/palindrome-partitioning-ii/discuss/42198/My-solution-does-not-need-a-table-for-palindrome-is-it-right-It-uses-only-O(n)-space.")

    **Explanation 1:**

    This divide-and-conquer algorithm utilize the symmetry of palindromes, so there is no need to cache the result of whether `s[i:j]` is a palindrome.

    Say that it started at `s[i] = 'b'`, and `s[i-1,i+1]` is a palindrome “aba”:

    ```text
    .......aba...
    |<-X->| ^
    |<---Y-->|
    ```

    And we know the least cuts for `s[0,i-1]` is X, then the least cuts for `s[0,i+1]` Y is not greater than X+1. Last, we need to find out all the palindromes in `s[0,i+1]` so as to minimize the number of cuts.

    **Explanation 2:**

    The definition of ‘cut’ array is the minimum number of cuts of a sub string. More specifically, cut[n] stores the cut number of string s[0, n-1].

    Here is the basic idea of the solution:

    Initialize the ‘cut’ array: For a string with n characters s[0, n-1], it needs at most n-1 cut. Therefore, the ‘cut’ array is initialized as cut[i] = i-1

    Use two variables in two loops to represent a palindrome:

    The external loop variable ‘i’ represents the center of the palindrome. The internal loop variable ‘j’ represents the ‘radius’ of the palindrome. Apparently, j <= i is a must.

    This palindrome can then be represented as s[i-j, i+j]. If this string is indeed a palindrome, then one possible value of cut[i+j] is cut[i-j] + 1, where cut[i-j] corresponds to s[0, i-j-1] and 1 correspond to the palindrome s[i-j, i+j];

    When the loops finish, you’ll get the answer at cut[s.length]