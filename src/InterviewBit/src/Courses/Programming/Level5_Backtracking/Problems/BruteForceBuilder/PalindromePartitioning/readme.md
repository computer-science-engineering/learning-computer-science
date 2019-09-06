# Problem Definition

## Description

Given a string s, partition s such that every string of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given `s = "aab"`,

Return

```plaintext
  [
    ["a","a","b"]
    ["aa","b"],
  ]
```

```plaintext
 Ordering the results in the answer : Entry i will come before Entry j if :
* len(Entryi[0]) < len(Entryj[0]) OR
* (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
  *
  *
  *
* (len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))
```

In the given example,
`["a", "a", "b"]` comes before `["aa", "b"]` because `len("a") < len("aa")`

## Notes

1. [LeetCode discussion](https://leetcode.com/problems/palindrome-partitioning/discuss/41963/Java:-Backtracking-solution.)