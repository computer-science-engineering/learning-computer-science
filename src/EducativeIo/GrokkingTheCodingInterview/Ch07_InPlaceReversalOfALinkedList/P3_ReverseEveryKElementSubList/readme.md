# Problem Definition

## Description

Given the head of a LinkedList and a number ‘k’, **reverse every ‘k’ sized sub-list** starting from the head.

If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.

## Notes

The problem follows the **In-place Reversal of a LinkedList** pattern and is quite similar to **Reverse a Sub-list**. The only difference is that we have to reverse all the sub-lists. We can use the same approach, starting with the first sub-list (i.e. `p=1, q=k`) and keep reversing all the sublists of size ‘k’.

### Time Complexity

### Space Complexity

## References
