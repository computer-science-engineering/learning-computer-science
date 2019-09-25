# Problem Definition

## Description

Problem Statement
Given a set of numbers that might contain duplicates, find all of its distinct subsets.

Example 1:

```plaintext
Input: [1, 3, 3]
Output: [], [1], [3], [1,3], [3,3], [1,3,3]
```

Example 2:

```plaintext
Input: [1, 5, 3, 3]
Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3], [3,3], [1,3,3], [3,3,5], [1,5,3,3]
```

## Discussion

This problem follows the **Subsets** pattern and we can follow a similar **Breadth First Search (BFS)** approach. The only additional thing we need to do is handle duplicates. Since the given set can have duplicate numbers, if we follow the same approach discussed in **Subsets**, we will end up with duplicate subsets, which is not acceptable. To handle this, we will do two extra things:

1. Sort all numbers of the given set. This will ensure that all duplicate numbers are next to each other.
2. Follow the same BFS approach but whenever we are about to process a duplicate (i.e., when the current and the previous numbers are same), instead of adding the current number (which is a duplicate) to all the existing subsets, only add it to the subsets which were created in the previous step.

Let’s take Example-2 mentioned above to go through each step of our algorithm:

```plaintext
Given set: [1, 5, 3, 3]  
Sorted set: [1, 3, 3, 5]
```

1. Start with an empty set: [[]]
2. Add the first number (1) to all the existing subsets to create new subsets: [[], [1]];
3. Add the second number (3) to all the existing subsets: [[], [1], [3], [1,3]].
4. The next number (3) is a duplicate. If we add it to all existing subsets we will get:

    ```plaintext
    [[], [1], [3], [1,3], [3], [1,3], [3,3], [1,3,3]]
    We got two duplicate subsets: [3], [1,3]  
    Whereas we only needed the new subsets: [3,3], [1,3,3]
    ```

    To handle this instead of adding (3) to all the existing subsets, we only add it to the new subsets which were created in the previous (3rd) step:

    ```plaintext
    [[], [1], [3], [1,3], [3,3], [1,3,3]]
    ```

5. Finally, add the forth number (5) to all the existing subsets: [[], [1], [3], [1,3], [3,3], [1,3,3], [5], [1,5], [3,5], [1,3,5], [3,3,5], [1,3,3,5]]

### Time Complexity

Since, in each step, the number of subsets could double (if not duplicate) as we add each element to all the existing subsets, the time complexity of the above algorithm is O(2^N), where ‘N’ is the total number of elements in the input set. This also means that, in the end, we will have a total of O(2^N) subsets at the most.

### Space Complexity

All the additional space used by our algorithm is for the output list. Since at most we will have a total of O(2^N) subsets, the space complexity of our algorithm is also O(2^N).

## Notes

## References
