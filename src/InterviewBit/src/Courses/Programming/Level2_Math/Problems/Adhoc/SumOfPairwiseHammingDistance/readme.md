# Sum Of Pairwise Hamming Distance

## Link

[Here](https://www.interviewbit.com/problems/sum-of-pairwise-hamming-distance/)

## Description

[Hamming distance](https://en.wikipedia.org/wiki/Hamming_distance) between two non-negative integers is defined as the number of positions at which the corresponding bits are different.

For example,

HammingDistance(2, 7) = 2, as only the first and the third bit differs in the binary representation of 2 (010) and 7 (111).

Given an array of N non-negative integers, find the sum of hamming distances of all pairs of integers in the array.
Return the answer modulo 1000000007.

Example:

Let f(x, y) be the hamming distance defined above.

A=[2, 4, 6]

We return,

```text
f(2, 2) + f(2, 4) + f(2, 6) +
f(4, 2) + f(4, 4) + f(4, 6) +
f(6, 2) + f(6, 4) + f(6, 6) =

0 + 2 + 1
2 + 0 + 1
1 + 1 + 0 = 8
```

## Companies

1. Google

## Categories

1. Courses
1. Programming

## Tags

1. Math

## Notes

1. [SO post](https://stackoverflow.com/questions/21388448/sum-of-xor-values-of-all-pairs)
1. [SO post](https://stackoverflow.com/questions/28095890/sum-of-hamming-distances)
1. [SO post on bit manipulation](https://stackoverflow.com/questions/141525/what-are-bitwise-shift-bit-shift-operators-and-how-do-they-work)
1. [GfG problem](http://www.geeksforgeeks.org/sum-of-bit-differences-among-all-pairs/)
1. [GfG article on bit manipulation](http://notes4geeks.com/main/bit/bit_manipulation.html)
1. [GfG Video](https://www.youtube.com/watch?v=cfizo_K7e0o)
1. [Bitwise alternative to arithmetic operations](http://jacksondunstan.com/articles/1946)

**Converting decimal to binary using bit shifting:**

```c++
// i is the input value - decimal number
for (j = numberOfBits-1; j >= 0; --j) {
    if (i & (1 << j))
        putChar('1');
    else
        putChar('0');
}
```