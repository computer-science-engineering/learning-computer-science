# Problem Definition

## Description

Find out the maximum sub-array of non negative numbers from an array. The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if `sum(A) > sum(B)`.

**Example:**

```plaintext
A : [1, 2, 5, -7, 2, 3]
The two sub-arrays are [1, 2, 5] [2, 3].
The answer is [1, 2, 5] as its sum is larger than [2, 3]
```

**NOTE:** If there is a tie, then compare with segment's length and return segment which has maximum length.

**NOTE 2:** If there is still a tie, then return the segment with minimum starting index.

## Notes

1. [Geeks for Geeks - Longest Subarray of non-negative Integers](https://www.geeksforgeeks.org/longest-subarray-non-negative-integers/)