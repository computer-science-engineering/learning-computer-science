# Problem Definition

## Description

Implement atoi to convert a string to an integer.

Example :

Input : "9 2704"
Output : 9
Note: There might be multiple corner cases here. Clarify all your doubts using “See Expected Output”.

Questions:
Q1. Does string contain whitespace characters before the number?
A. Yes
Q2. Can the string have garbage characters after the number?
A. Yes. Ignore it.
Q3. If no numeric character is found before encountering garbage characters, what should I do?
A. Return 0.
Q4. What if the integer overflows?
A. Return INT_MAX if the number is positive, INT_MIN otherwise.
Warning : DO NOT USE LIBRARY FUNCTION FOR ATOI.
If you do, we will disqualify your submission retroactively and give you penalty points.

## Notes

1. [Program Creek](https://www.programcreek.com/2012/12/leetcode-string-to-integer-atoi/)
1. [SO post](https://stackoverflow.com/a/8039123/420827)