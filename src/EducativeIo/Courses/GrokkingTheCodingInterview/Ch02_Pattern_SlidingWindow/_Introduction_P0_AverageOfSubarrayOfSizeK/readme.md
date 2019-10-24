# Problem Definition

## Description

Given an array, find the average of all subarrays of size `K` in it.

Let’s understand this problem with a real input:

`Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5`

Here, we are asked to find the average of all subarrays of size ‘5’ in the given array. Let’s solve this:

1. For the first 5 numbers (subarray from index 0-4), the average is: (1+3+2+6-1)/5 => 2.2
2. The average of next 5 numbers (subarray from index 1-5) is: (3+2+6-1+4)/5 => 2.8
3. For the next 5 numbers (subarray from index 2-6), the average is: (2+6-1+4+1)/5 => 2.4
4. …

Here is the final output containing the averages of all subarrays of size 5:

`Output: [2.2, 2.8, 2.4, 3.6, 2.8]`

## Notes
