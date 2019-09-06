# Problem Definition

## Description

Given a non-negative integer `c`, your task is to decide whether there're two integers `a` and `b` such that a<sup>2</sup> + b<sup>2</sup> = c.

**Example 1:**

```plaintext
Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5
```

**Example 2:**

```plaintext
Input: 3
Output: False
```

## Notes

1. [LeetCode discussion - Java Two Pointers Solution](https://leetcode.com/problems/sum-of-square-numbers/discuss/104930/Java-Two-Pointers-Solution)

    ```java
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        int left = 0, right = (int)Math.sqrt(c);
        while (left <= right) {
            int cur = left * left + right * right;
            if (cur < c) {
                left++;
            } else if (cur > c) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }
    ```

1. [LeetCode discussion - HashSet, Java, quick solution, one for loop](https://leetcode.com/problems/sum-of-square-numbers/discuss/104932/HashSet-Java-quick-solution-one-for-loop)
1. [LeetCode article](https://leetcode.com/articles/sum-of-square-numbers/)
1. [LeetCode discussion - Fermat](https://leetcode.com/problems/sum-of-square-numbers/discuss/104935/Fermat)

    A natural number is a sum of two squares if and only if each prime factor that's 3 modulo 4 occurs to an even power in the number's prime factorization.