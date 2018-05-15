# Problem Definition

## Description

The count-and-say sequence is the sequence of integers beginning as follows:

1, 11, 21, 1211, 111221, ...
1 is read off as one 1 or 11.
11 is read off as two 1s or 21.

21 is read off as one 2, then one 1 or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

Example:

if n = 2,
the sequence is 11.

## Notes

1. [Geeks for Geeks](http://www.geeksforgeeks.org/look-and-say-sequence/)

    The idea is simple, we generate all terms from 1 to n. First two terms are initialized as “1” and “11”, and all other terms are generated using previous terms. To generate a term using previous term, we scan the previous term. While scanning a term, we simply keep track of count of all consecutive characters. For sequence of same characters, we append the count followed by character to generate the next term.

1. [YT Video - Scott - Count and Say](https://www.youtube.com/watch?v=kAt-4y0qG8Q)