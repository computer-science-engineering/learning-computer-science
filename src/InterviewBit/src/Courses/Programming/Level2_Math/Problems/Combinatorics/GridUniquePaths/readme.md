# Grid Unique Paths

## Link

[Here](https://www.interviewbit.com/problems/grid-unique-paths/)

## Description

A robot is located at the top-left corner of an A x B grid (marked ‘Start’ in the diagram below).

Path Sum: Example 1

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).

How many possible unique paths are there?

Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.

Example:

```text
Input : A = 2, B = 2
Output : 2

2 possible routes : (0, 0) -> (0, 1) -> (1, 1)
              OR  : (0, 0) -> (1, 0) -> (1, 1)
```

## Companies

1. Google
1. Amazon
1. Microsoft
1. Adobe

## Categories

1. Courses
1. Programming

## Tags

1. Math

## Notes

### Basic algorithm

* Recursion is the key here.
* Take the rows count and col­umn counts say row­Count and col­Count respectively.
* Take cur­ren­tRow =0 and cur­rent­Col­umn =0 and path ="".
* Call findAll(currentRow, currentColumn,path).
* Add array[0][0] to the path.
* Call recursively findAll(currentRow+1, currentColumn,path).
* Call recursively findAll(currentRow, currentColumn+1,path).
* Base Case 1: when cur­ren­tRow = rowCount-1(because array index starts with 0) , print the rest of the columns, return.
* Base Case 2: when cur­rent­col­umn = colCount-1(because array index starts with 0) , print the rest of the rows, return.

[Reference](http://algorithms.tutorialhorizon.com/print-all-paths-from-top-left-to-bottom-right-in-two-dimensional-array/)

### Other

1. [GfG problem](http://www.geeksforgeeks.org/print-all-possible-paths-from-top-left-to-bottom-right-of-a-mxn-matrix/)
1. [GfG problem](http://www.geeksforgeeks.org/unique-paths-in-a-grid-with-obstacles/)