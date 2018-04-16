# Problem Definition

## Description

Given an integer array, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p. If such an integer is found return 1 else return -1.

## Notes

1. [Geeks for Geeks - Noble integers in an array (count of greater elements is equal to value)](https://www.geeksforgeeks.org/noble-integers-in-an-array-count-of-greater-elements-is-equal-to-value/)

    * Sort the Array arr[] in ascending order. This step takes (O(nlogn)).
    * Iterate through the array. Compare the value of index i to the number of elements after index i. If arr[i] equals the number of elements after arr[i], it is a noble Integer. Condition to check: (A[i] == length-i-1). This step takes O(n).