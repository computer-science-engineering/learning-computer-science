# Greatest Common Divisor

## Origin

[Link](https://www.interviewbit.com/problems/greatest-common-divisor/)

## Description

Given 2 non negative integers m and n, find gcd(m, n)

GCD of 2 integers m and n is defined as the greatest integer g such that g is a divisor of both m and n.
Both m and n fit in a 32 bit signed integer.

Example

```text
m : 6
n : 9

GCD(m, n) : 3
```

NOTE: DO NOT USE LIBRARY FUNCTIONS

## Companies

1. Google
1. NetApp

## Categories

1. Courses
1. Programming

## Tags

1. Math

## Notes

### Euclid’s Algorithm for the greatest common divisor

The greatest common divisor (gcd) of two positive integers is the largest integer that divides both without remainder. Euclid’s algorithm is based on the following property: if p>q then the gcd of p and q is the same as the gcd of p%q and q. p%q is the remainder of p which cannot be divided by q, e.g. 33 % 5 is 3. This is based on the fact that the gcd of p and q also must divided (p-q) or (p-2q) or (p-3q). Therefore you can subtract the maximum of a multitude q from p which is p%q.

[Reference](http://www.vogella.com/tutorials/JavaAlgorithmsEuclid/article.html#overview)

### Approach

```text
Lets say g is gcd(m, n) and m > n.

m = g * m1
n = g * m2

m - n = g * (m1 - m2)

gcd (m, n) = gcd(m-n, n)

           = gcd(m - 2n, n) if m >= 2n
           = gcd(m - 3n, n) if m >= 3n
             .
             .
             .
           = gcd(m - k*n, n) if m >= k*n

In other words, we keep subtracting n till the result is greater than 0. 
Ultimately we will end up with m % n.
So gcd(m, n)  = gcd(m % n, n)
```