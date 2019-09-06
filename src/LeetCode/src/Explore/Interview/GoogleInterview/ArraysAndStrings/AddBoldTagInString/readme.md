# Problem Definition

## Description

Given a string **s** and a list of strings **dict**, you need to add a closed pair of bold tag `<b>` and `</b>` to wrap the substrings in **s** that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.

**Example 1:**

```plaintext
Input:
s = "abcxyz123"
dict = ["abc","123"]
Output:
"<b>abc</b>xyz<b>123</b>"
```

**Example 2:**

```plaintext
Input:
s = "aaabbcc"
dict = ["aaa","aab","bc"]
Output:
"<b>aaabbc</b>c"
```

**Note:**

1. The given dict won't contain duplicates, and its length won't exceed 100.
2. All the strings in input have length in range [1, 1000].

## Notes

1. [LeetCode solution](https://leetcode.com/problems/add-bold-tag-in-string/solution/)
1. [LeetCode discussion - Java solution, Same as Merge Interval.](https://leetcode.com/explore/interview/card/google/59/array-and-strings/337/discuss/104263/Java-solution-Same-as-Merge-Interval.)
1. [LeetCode discussion - Java Solution, boolean array](https://leetcode.com/explore/interview/card/google/59/array-and-strings/337/discuss/104248/Java-Solution-boolean-array)