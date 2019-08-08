# Problem Definition

## Description

Given the head of a **Singly LinkedList**, write a method to return the **middle node** of the LinkedList.

If the total number of nodes in the LinkedList is even, return the second middle node.

Example 1:

```text
Input: 1 -> 2 -> 3 -> 4 -> 5 -> null
Output: 3
```

Example 2:

```text
Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
Output: 4
```

Example 3:

```text
Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
Output: 4
```

## Notes

One brute force strategy could be to first count the number of nodes in the LinkedList and then find the middle node in the second iteration.

We can use the **Fast & Slow pointers** method such that the fast pointer is always twice the nodes ahead of the slow pointer. This way, when the fast pointer reaches the end of the LinkedList, the slow pointer will be pointing at the middle node.

### Time complexity

The above algorithm will have a time complexity of O(N) where ‘N’ is the number of nodes in the LinkedList.

### Space complexity

The algorithm runs in constant space O(1).

## References
