# Rearrange Array

## Link

[Here](https://www.interviewbit.com/problems/rearrange-array/)

## Description

Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

Example:

Input : [1, 0]

Return : [0, 1]

Lets say N = size of the array. Then, following holds true:

* All elements in the array are in the range [0, N-1]
* N * N does not overflow for a signed integer

## Companies

1. Facebook

## Categories

1. Courses
1. Programming

## Tags

1. Math

## Notes

1. [GfG problem](http://www.geeksforgeeks.org/rearrange-given-array-place/)

ex: arr[]={2,1,0};
1st loop:
arr[0]=arr[0]+(arr[arr[0]]%3)*3 = 2+(arr[2]%3)*3 = 2+(0%3)*3 = 2
arr[1]=arr[1]+(arr[arr[1]]%3)*3 = 1+(arr[1]%3)*3 = 1+(1%3)*3 = 4
arr[2]=arr[2]+(arr[arr[2]]%3)*3 = 0+(arr[0]%3)*3 = 0+(2%3)*3 = 6 // modulo needed to get original value of arr[0]
2nd loop:
arr[0]=arr[0]/3 = 2/3 = 0
arr[1]=arr[1]/3 = 4/3 = 1
arr[2]=arr[2]/3 = 6/3 = 2