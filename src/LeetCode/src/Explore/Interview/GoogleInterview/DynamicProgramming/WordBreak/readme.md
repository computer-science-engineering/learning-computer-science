# Problem Definition

## Description

Given a **non-empty** string s and a dictionary _wordDict_ containing a list of **non-empty** words, determine if _s_ can be segmented into a space-separated sequence of one or more dictionary words.

**Note:**

* The same word in the dictionary may be reused multiple times in the segmentation.
* You may assume the dictionary does not contain duplicate words.

**Example 1:**

```text
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
````

**Example 2:**

```text
Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
```

**Example 3:**

```text
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
```

## Notes

1. [LeetCode discussion - Java implementation using DP in two ways](leetcode.com/explore/interview/card/google/64/dynamic-programming-4/348/discuss/43790/Java-implementation-using-DP-in-two-ways/42970)
1. [LeetCode discussion - Java Impl - Trie with Memo - beats 40ish%](https://leetcode.com/explore/interview/card/google/64/dynamic-programming-4/348/discuss/211670/Java-Impl-Trie-with-Memo-beats-40ish)
1. [LeetCode discussion - Simple Java backtracking solution with memo, beats 98%](https://leetcode.com/explore/interview/card/google/64/dynamic-programming-4/348/discuss/213361/Simple-Java-backtracking-solution-with-memo-beats-98)

    ```java
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> invalidStrings = new HashSet<>();
        return backtrack(s, wordDict, invalidStrings);
    }

    private boolean backtrack(String remaining, List<String> wordDict, Set<String> invalidStrings) {
        if (remaining.isEmpty()) return true;
        if (invalidStrings.contains(remaining)) return false;
        for (String word : wordDict) {
            if (remaining.startsWith(word)) {
                if (backtrack(remaining.substring(word.length()), wordDict, invalidStrings)) return true;
            }
        }
        invalidStrings.add(remaining);
        return false;
    }
    ```