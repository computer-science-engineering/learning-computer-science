# Problem Definition

## Description

Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.

Example 1:

```text
Input: str1="xy#z", str2="xzz#"
Output: true
Explanation: After applying backspaces the strings become "xz" and "xz" respectively.
```

Example 2:

```text
Input: str1="xy#z", str2="xyz#"
Output: false
Explanation: After applying backspaces the strings become "xz" and "xy" respectively.
```

Example 3:

```text
Input: str1="xp#", str2="xyz##"
Output: true
Explanation: After applying backspaces the strings become "x" and "x" respectively.
In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.
```

Example 4:

```text
Input: str1="xywrrmp", str2="xywrrmu#p"
Output: true
Explanation: After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.
```

## Notes

To compare the given strings we need to first apply the backspaces. An efficient way to do so would be from the end of both strings. We can have separate pointers, pointing to the last element of the given strings. We can start comparing the characters pointed out by both the pointers to see if the strings are equal. If, at any stage, the character pointed out by any of the pointers is a backspace ('#'), we will skip and apply the backspace until we have a valid character available for comparison.

### Time complexity

The time complexity of the above algorithm will be O(M+N) where ‘M’ and ‘N’ are the lengths of the two input strings respectively.

### Space complexity

The algorithm runs in constant space O(1).

## References

1. [YT Video - Kevin Naughton Jr. - Google Coding Interview (2019) - Backspace String Compare (LeetCode)](https://www.youtube.com/watch?v=96-d8ZPjHeE)
2. [YT Video - Nick White - LeetCode Backspace String Compare Solution Explained - Java](https://www.youtube.com/watch?v=vgog1EuEJYQ)
