# Palindrome Integer

## Link

[Here](https://www.interviewbit.com/problems/palindrome-integer/)

## Description

Determine whether an integer is a palindrome. Do this without extra space.

A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
Negative numbers are not palindromic.

Example :

```test
Input : 12121
Output : True

Input : 123
Output : False
```

## Companies

1. HCL

## Categories

1. Courses
1. Programming

## Tags

1. Math

## Notes

Principles:

* Modding (%) the input int by 10 will extract off the rightmost digit. example: (1234 % 10) = 4
* Multiplying an integer by 10 will "push it left" exposing a zero to the right of that number, example: (5 * 10) = 50
* Dividing an integer by 10 will remove the rightmost digit. (75 / 10) = 7