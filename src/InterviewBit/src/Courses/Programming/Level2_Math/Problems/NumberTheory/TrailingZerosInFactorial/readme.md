# Trailing Zeros In Factorial

## Link

[Here](https://www.interviewbit.com/problems/trailing-zeros-in-factorial/)

## Description

Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

Example :

```text
n = 5
n! = 120
Number of trailing zeros = 1
So, return 1
```

## Companies

1. Microsoft
1. Jabong
1. Zillow

## Categories

1. Courses
1. Programming

## Tags

1. Math

## Notes

1. [Algorithm @ purplemath](http://www.purplemath.com/modules/factzero.htm)
    * Take the number that you've been given the factorial of.
    * Divide by 5; if you get a decimal, truncate to a whole number.
    * Divide by 5^2 = 25; if you get a decimal, truncate to a whole number.
    * Divide by 5^3 = 125; if you get a decimal, truncate to a whole number.
    * Continue with ever-higher powers of 5, until your division results in a number less than 1. Once the division is less than 1, stop.
    * Sum all the whole numbers you got in your divisions. This is the number of trailing zeroes.
1. [GfG problem](http://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/)