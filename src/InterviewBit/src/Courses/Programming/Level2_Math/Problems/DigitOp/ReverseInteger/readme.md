# Reverse Integer

## Link

[Here](https://www.interviewbit.com/problems/reverse-integer/)

## Description

Reverse digits of an integer.

**Example1:**

x = 123,

return 321

**Example2:**

x = -123,

return -321

Return 0 if the result overflows and does not fit in a 32 bit signed integer

## Companies

1. HCL
1. Bloomberg

## Categories

1. Courses
1. Programming

## Tags

1. Math

## Notes

1. [SO post](https://stackoverflow.com/questions/3806126/java-reverse-an-int-value-without-using-array)

Java reverse an int value - Principles:

* Modding (%) the input int by 10 will extract off the rightmost digit. example: (1234 % 10) = 4
* Multiplying an integer by 10 will "push it left" exposing a zero to the right of that number, example: (5 * 10) = 50
* Dividing an integer by 10 will remove the rightmost digit. (75 / 10) = 7