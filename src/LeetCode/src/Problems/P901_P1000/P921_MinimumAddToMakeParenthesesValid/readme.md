# Problem Definition

## Description

Given a string `S` of `'('` and `')'` parentheses, we add the minimum number of parentheses ( `'('` or `')'`, and in any positions ) so that the resulting parentheses string is valid.

Formally, a parentheses string is valid if and only if:

* It is the empty string, or
* It can be written as `AB` (`A` concatenated with `B`), where `A` and `B` are valid strings, or
* It can be written as `(A)`, where `A` is a valid string.

Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.

**Example 1:**

```text
Input: "())"
Output: 1
```

**Example 2:**

```text
Input: "((("
Output: 3
```

**Example 3:**

```text
Input: "()"
Output: 0
```

**Example 4:**

```text
Input: "()))(("
Output: 4
```

**Note:**

1. `S.length <= 1000`
2. `S` only consists of `'('` and `')'` characters.

## Notes

1. [LeetCode solution](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/solution/)
1. [LeetCode discussion - [Java] two one pass 7 liners - space O(n) and O(1), respectively](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/discuss/181086/Java-two-one-pass-7-liners-space-O(n)-and-O(1)-respectively)
1. [LeetCode discussion - [Java] Easy to understand Stack Solution (8ms)](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/discuss/182799/Java-Easy-to-understand-Stack-Solution-(8ms))
1. LeetCode Top Submission

    ```java
    public int minAddToMakeValid(String S) {
        int result = 0;
        int netLeft = 0;
        for (char c: S.toCharArray()) {
            if (c=='(') {
                netLeft++;
            } else {
                netLeft--;
            }
            if (netLeft<0) {
                result-=netLeft;
                netLeft = 0;
            }
        }
        if (netLeft > 0) {
            result+=netLeft;
        }
        return result;
    }
    ```