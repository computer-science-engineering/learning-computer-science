# Problem Definition

## Description

Given an N * NN∗N matrix where each row and column is sorted in ascending order, find the Kth smallest element in the matrix.

Example 1:

```plaintext
Input: Matrix=[
    [2, 6, 8],
    [3, 7, 10],
    [5, 8, 11]
  ],
  K=5
Output: 7
Explanation: The 5th smallest number in the matrix is 7.
```

## Discussion

### Approach

This problem follows the **K-way merge pattern** and can be easily converted to **Kth Smallest Number in M Sorted Lists**. As each row (or column) of the given matrix can be seen as a sorted list, we essentially need to find the Kth smallest number in ‘N’ sorted lists.

#### Time Complexity

First, we inserted at most ‘K’ or one element from each of the ‘N’ rows, which will take O(min(K, N)). Then we went through at most ‘K’ elements in the matrix and remove/add one element in the heap in each step. As we can’t have more than ‘N’ elements in the heap in any condition, therefore, the overall time complexity of the above algorithm will be O(min(K, N) + K*logN).

#### Space Complexity

The space complexity will be O(N) because, in the worst case, our min-heap will be storing one number from each of the ‘N’ rows.

### Alternate Approach 1

Since each row and column of the matrix is sorted, is it possible to use **Binary Search** to find the Kth smallest number?

The biggest problem to use **Binary Search** in this case is that we don’t have a straightforward sorted array, instead we have a matrix. As we remember, in **Binary Search**, we calculate the middle index of the search space (‘1’ to ‘N’) and see if our required number is pointed out by the middle index; if not we either search in the lower half or the upper half. In a sorted matrix, we can’t really find a middle. Even if we do consider some index as middle, it is not straightforward to find the search space containing numbers bigger or smaller than the number pointed out by the middle index.

An alternative could be to apply the **Binary Search** on the “number range” instead of the “index range”. As we know that the smallest number of our matrix is at the top left corner and the biggest number is at the bottom lower corner. These two number can represent the “range” i.e., the `start` and the `end` for the **Binary Search**. Here is how our algorithm will work:

1. Start the **Binary Search** with `start = matrix[0][0]` and `end = matrix[n-1][n-1]`.
2. Find `middle` of the `start` and the `end`. This `middle` number is NOT necessarily an element in the matrix.
3. Count all the numbers smaller than or equal to `middle` in the matrix. As the matrix is sorted, we can do this in O(N).
4. While counting, we can keep track of the “smallest number greater than the `middle`” (let’s call it `n1`) and at the same time the “biggest number less than or equal to the `middle`” (let’s call it `n2`). These two numbers will be used to adjust the “number range” for the **Binary Search** in the next iteration.
5. If the count is equal to ‘K’, `n1` will be our required number as it is the “biggest number less than or equal to the `middle`”, and is definitely present in the matrix.
6. If the count is less than ‘K’, we can update `start = n2` to search in the higher part of the matrix and if the count is greater than ‘K’, we can update `end = n1` to search in the lower part of the matrix in the next iteration.

#### Time Complexity - Alternate Approach 1

The **Binary Search** could take O(log(max-min )) iterations where ‘max’ is the largest and ‘min’ is the smallest element in the matrix and in each iteration we take O(N) for counting, therefore, the overall time complexity of the algorithm will be O(N*log(max-min)).

#### Space Complexity - Alternate Approach 1

The algorithm runs in constant space O(1).

## Notes

## References
