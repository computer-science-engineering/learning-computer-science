# Problem Definition

## Description

Given a 32-bit signed integer, reverse digits of an integer.

**Example 1:**

Input: 123
Output: 321

**Example 2:**

Input: -123
Output: -321

**Example 3:**

Input: 120
Output: 21

**Note:**

Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2<sup>31</sup>,  2<sup>31</sup> − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

## Notes

1. [Geeks for Geeks - Horner’s Method for Polynomial Evaluation](https://www.geeksforgeeks.org/horners-method-polynomial-evaluation/)
1. [LeetCode discussion - My accepted 15 lines of code for Java](https://leetcode.com/problems/reverse-integer/discuss/4060/My-accepted-15-lines-of-code-for-Java)
1. [LeetCode discussion - Very Short (7 lines) and Elegant Solution](https://leetcode.com/problems/reverse-integer/discuss/4056/Very-Short-(7-lines)-and-Elegant-Solution)
1. [LeetCode solution](https://leetcode.com/problems/reverse-integer/solution/)
1. LeetCode sample submission - 13 ms

    ```Java
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return (int)res == res ? (int)res : 0;
    }
    ```