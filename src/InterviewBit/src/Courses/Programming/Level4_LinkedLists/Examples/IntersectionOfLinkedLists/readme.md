# Problem Definition

## Description

Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

```text
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
```

begin to intersect at node c1.

**Notes:**

* If the two linked lists have no intersection at all, return null.
* The linked lists must retain their original structure after the function returns.
* You may assume there are no cycles anywhere in the entire linked structure.
* Your code should preferably run in O(n) time and use only O(1) memory.

## Notes

1. [MyCodeSchool video](https://www.youtube.com/watch?v=gE0GopCq378)
1. [LeetCode discussion](https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785)
1. [LeetCode discussion](https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49805)
    * Scan both lists
    * For each list once it reaches the end, continue scanning the other list
    * Once the two runner equal to each other, return the position
    * Time O(n+m), space O(1)