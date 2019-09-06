# Problem Definition

## Description

Given a string, find the length of the longest substring T that contains at most *k* distinct characters.

**Example 1:**

```plaintext
Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
```

**Example 2:**

```plaintext
Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.
```

## Notes

1. [LeetCode discussion - Java: Sliding window + HashMap](https://leetcode.com/explore/interview/card/google/59/array-and-strings/332/discuss/152392/Java:-Sliding-window-+-HashMap)
1. [LeetCode discussion - 15 lines java solution using slide window](https://leetcode.com/explore/interview/card/google/59/array-and-strings/332/discuss/80047/15-lines-java-solution-using-slide-window)

    ```java
    public static int lengthOfLongestSubstringKDistinct2(String s, int k) {
        int[] count = new int[256];
        int num = 0, i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) num++;
            if (num > k) {
                while (--count[s.charAt(i++)] > 0);
                num--;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
    ```