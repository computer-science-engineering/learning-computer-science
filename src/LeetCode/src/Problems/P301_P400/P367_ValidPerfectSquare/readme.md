# Problem Definition

## Description

Given a positive integer *num*, write a function which returns True if *num* is a perfect square else False.

Note: **Do not** use any built-in library function such as `sqrt`.

**Example 1:**

```text
Input: 16
Returns: True
```

**Example 2:**

```text
Input: 14
Returns: False
```

## Notes

1. [LeetCode discussion - A square number is 1+3+5+7+..., JAVA code](https://leetcode.com/problems/valid-perfect-square/discuss/83874/A-square-number-is-1+3+5+7+...-JAVA-code)
1. [LeetCode discussion - Java Three Solutions 1,3,5,.. Sequence/Binary Search/Newton](https://leetcode.com/problems/valid-perfect-square/discuss/83902/Java-Three-Solutions-135..-SequenceBinary-SearchNewton)

    * a square number is 1+3+5+7+... Time Complexity O(sqrt(N)).
    * binary search. Time Complexity O(logN).
    * Newton Method. See [this wiki page](https://en.wikipedia.org/wiki/Newton%27s_method). Time Complexity is close to constant, given a positive integer.

    ```java
    public boolean isPerfectSquare(int num) {
      if (num < 1) return false;
      for (int i = 1; num > 0; i += 2)
        num -= i;
      return num == 0;
    }

    [O(logN) Bisection method](https://leetcode.com/problems/valid-perfect-square/discuss/83888/O(logN)-Bisection-method)
    bool isPerfectSquare(int num) {
        long long l = 0, r = num;
        while (l <= r) {
            long mid = (l + r) >> 1;
            long sqmid = mid * mid;
            if (sqmid > num) r = mid - 1;
            else if (sqmid < num) l = mid + 1;
            else return true;
        }
        return false;
    }

    boolean isPerfectSquare(int num) {
        // Newton's method.
        // Find square root of num and square it
        // square == num ? true : false;

        long t = num;
        while (t * t > num) {
            t = (t + num / t) / 2;
        }
        return t * t == num;
    }
    ```