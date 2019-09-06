# Problem Definition

## Description

Given an even number (greater than 2), return two prime numbers whose sum will be equal to given number.

NOTE: A solution will always exist. read [Goldbach’s conjecture](https://en.wikipedia.org/wiki/Goldbach%27s_conjecture)

Example:

```plaintext
Input : 4
Output: 2 + 2 = 4
```

If there are more than one solutions possible, return the lexicographically smaller solution.

```plaintext
If [a, b] is one solution with a <= b,
and [c, d] is another solution with c <= d, then

[a, b] < [c, d]

If a < c OR a==c AND b < d.
```

## Notes
