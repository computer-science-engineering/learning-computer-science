# Problem Definition

## Description

Given an input string (`s`) and a pattern (`p`), implement regular expression matching with support for `'.'` and `'*'`.

```plaintext
'.' Matches any single character.
'*' Matches zero or more of the preceding element.
```

The matching should cover the entire input string (not partial).

**Note:**

* `s` could be empty and contains only lowercase letters `a-z`.
* `p` could be empty and contains only lowercase letters `a-z`, and characters like `.` or `*`.

**Example 1:**

```plaintext
Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the **entire** string "aa".
```

**Example 2:**

```plaintext
Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
```

**Example 3:**

```plaintext
Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
```

**Example 4:**

```plaintext
Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
```

**Example 5:**

```plaintext
Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
```

## Notes

1. [ProgramCreek - LeetCode – Regular Expression Matching in Java](https://www.programcreek.com/2012/12/leetcode-regular-expression-matching-in-java/)
1. [Geeks for Geeks - Wildcard Pattern Matching](https://www.geeksforgeeks.org/wildcard-pattern-matching/)
1. [LeetCode discussion - Easy DP Java Solution with detailed Explanation](https://leetcode.com/problems/regular-expression-matching/discuss/5651/Easy-DP-Java-Solution-with-detailed-Explanation)

    ```plaintext
    1. If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
    2. If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
    3. If p.charAt(j) == '*':
        here are two sub conditions:
               1. if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
               2. if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
    ```

1. [LeetCode article](https://leetcode.com/articles/regular-expression-matching/)