# Problem Definition

## Description

Suppose you are given an array containing non-negative numbers representing heights of a set of buildings. Now, because of differences in heights of buildings water can be trapped between them. Find the **two buildings that will trap the most amount of water**. Write a function that will return the maximum volume of water that will be trapped between these two buildings.

Example 1:

```text
Input: [1, 3, 5, 4, 1]
Output: 6
Explanation: The maximum water will be trapped between buildings of height 3 and 4.
```

Example 2:

```text
Input: [3, 2, 5, 4, 2]
Output: 9
Explanation: The maximum water will be trapped between buildings of height 3 and 4.
```

Example 3:

```text
Input: [1, 4, 3, 2, 5, 8, 4]
Output: 20
Explanation: The maximum water will be trapped between buildings of height 4 and 4.
```

## Notes

As we can clearly see, the amount of water trapped between two buildings is limited by the height of the shorter building. Which means that we can’t trap water more than the height of the shorter building. For example, if there are two buildings of height 3 and 4, the maximum water we can trap between them will be `min(3, 4) = 3 units`.

We can use a Two Pointers approach, starting with one pointer in the beginning and one at the end of the array. We will keep calculating the water trapped by the two buildings pointed out by the two pointers. As we discussed above, the limiting factor is the shorter building, therefore, whichever building is shorter, we will increment that pointer to see if we can get a better building.

### Time complexity

The time complexity of the above algorithm will be O(N).

### Space complexity

The algorithm runs in constant space O(1).

## References
