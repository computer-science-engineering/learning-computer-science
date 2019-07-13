# Problem Definition

## Description

Given a string with lowercase letters only, if you are allowed to **replace no more than 'k' letters** with any letter, find the **length of the longest substring having the same letters** after replacement.

Example 1:

```text
Input: String="aabccbb", k=2
Output: 5
Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
```

Example 2:

```text
Input: String="abbcb", k=1
Output: 4
Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
```

Example 3:

```text
Input: String="abccde", k=1
Output: 3
Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
```

## Notes

### Time Complexity

For the Sliding Window algorithm, the time complexity is O(N) where 'N' is the number of letters in the input string.

### Space Complexity

For the Sliding Window algorithm, the space complexity is also O(N) since in the worst case, the whole string might have distinct letters so the entire string will be added to the **HashMap**.
