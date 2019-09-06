# Problem Definition

## Description

Merge k sorted linked lists and return it as one sorted list.

Example :

```plaintext
1 -> 10 -> 20
4 -> 11 -> 13
3 -> 8 -> 9
```

will result in

```plaintext
1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
```

## Notes

1. [LeetCode discussion](https://leetcode.com/problems/merge-k-sorted-lists/discuss/10528/A-java-solution-based-on-Priority-Queue)
1. [yusun blog](https://yusun2015.wordpress.com/2015/01/16/merge-k-sorted-lists/)

    * use a heap and put all the nodes in the heap.
    * insert the node on the top of the head to the list and put the node.next into the heap.
    * if we have total n nodes and k sorted list, then the complexity is O(long(k)).

### Solution Approach

There are 2 approaches to solving the problem.

Approach 1 - Using heap: At every instant, you need the minimum of the head of all the k linked list. Once you know the minimum, you can push the node to your answer list, and move over to the next node in that linked list.

Approach 2 - Divide and conquer: Solve the problem for first k/2 and last k/2 list. Then you have 2 sorted lists. Then simply merge the lists. Time complexity:

```plaintext
T(N) = 2 T(N/2) + N
T(N) = O (N log N)
```