# Problem Definition

## Description

We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’. The array originally contained all the numbers from 1 to ‘n’, but due to a data error, one of the numbers got duplicated which also resulted in one number going missing. Find both these numbers.

Example 1:

```plaintext
Input: [3, 1, 2, 5, 2]
Output: [2, 4]
Explanation: '2' is duplicated and '4' is missing.
```

Example 2:

```plaintext
Input: [3, 1, 2, 3, 6, 4]
Output: [3, 5]
Explanation: '3' is duplicated and '5' is missing.
```

## Notes

This problem follows the **Cyclic Sort** pattern and shares similarities with **Find all Duplicate Numbers**. Following a similar approach, we will place each number at its correct index. Once we are done with the cyclic sort, we will iterate through the array to find the number that is not at the correct index. Since only one number got corrupted, the number at the wrong index is the duplicated number and the index itself represents the missing number.

### Time Complexity

The time complexity of the above algorithm is O(n) as we are iterating the input array only two times.

### Space Complexity

The algorithm runs in constant space O(1).

## References
