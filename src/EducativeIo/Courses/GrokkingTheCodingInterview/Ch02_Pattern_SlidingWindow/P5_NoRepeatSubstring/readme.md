# Problem Definition

## Description

Given a string, find the **length of the longest substring** which has **no repeating characters**.

Example 1:

```plaintext
Input: String="aabccbb"
Output: 3
Explanation: The longest substring without any repeating characters is "abc".
```

Example 2:

```plaintext
Input: String="abbbb"
Output: 2
Explanation: The longest substring without any repeating characters is "ab".
```

Example 3:

```plaintext
Input: String="abccde"
Output: 3
Explanation: Longest substrings without any repeating characters are "abc" & "cde".
```

## Notes

### Time Complexity

For the Sliding Window algorithm, the time complexity will be O(N) where ‘N’ is the number of characters in the input string.

### Space Complexity

For the Sliding Window algorithm, the space complexity of the algorithm is also O(N) because in the worst case, the whole string might not have any repeating character so the entire string will be added to the HashMap. Having said that, since we can expect a fixed set of characters in the input string (e.g., 26 for English letters), we can say that the algorithm runs in fixed space O(1).
