# Problem Definition

## Description

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = `"aab"`,
Return

```plaintext
[
  ["aa","b"],
  ["a","a","b"]
]
```

## Notes

1. [YT Video - Tushar Roy - Palindrome Partition Dynamic Programming](https://www.youtube.com/watch?v=lDYIvtBVmgo)

    ```plaintext
    if isPalindrome(i, j)
      T[i][j] = 0;
    else
      T[i][j] = 1 + min(T[i][k] + T[k+1][j]) ; where k = i,..,j-1.
    ```

1. [GitHub - Tushar Roy](https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/PalindromePartition.java)
1. [YT Video - IDeserve - Palindrome Partitioning Dynamic Programming](https://www.youtube.com/watch?v=WPr1jDh3bUQ)