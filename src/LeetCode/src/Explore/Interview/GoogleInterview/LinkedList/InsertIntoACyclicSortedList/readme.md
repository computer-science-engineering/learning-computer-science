# Problem Definition

## Description

Given a node from a cyclic linked list which is sorted in ascending order, write a function to insert a value into the list such that it remains a cyclic sorted list. The given node can be a reference to any single node in the list, and may not be necessarily the smallest value in the cyclic list.

If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the insertion, the cyclic list should remain sorted.

If the list is empty (i.e., given node is `null`), you should create a new single cyclic list and return the reference to that single node. Otherwise, you should return the original given node.

The following example may help you understand the problem better:

[![insert cyclic before](https://assets.leetcode.com/uploads/2018/10/12/insertcyclicbefore.png)](https://assets.leetcode.com/uploads/2018/10/12/insertcyclicbefore.png)

In the figure above, there is a cyclic sorted list of three elements. You are given a reference to the node with value 3, and we need to insert 2 into the list.

[![insert cyclic after](https://assets.leetcode.com/uploads/2018/10/12/insertcyclicafter.png)](https://assets.leetcode.com/uploads/2018/10/12/insertcyclicafter.png)

The new node should insert between node 1 and node 3. After the insertion, the list should look like this, and we should still return node 3.

## Notes

1. [LeetCode article](https://articles.leetcode.com/insert-into-a-cyclic-sorted-list/)
1. [LeetCode discussion - Java 5ms One Pass and Two Pass Traverse With Detailed Comments and Edge cases!](https://leetcode.com/explore/interview/card/google/60/linked-list-5/1342/discuss/149374/Java-5ms-One-Pass-and-Two-Pass-Traverse-With-Detailed-Comments-and-Edge-cases!)
1. [LeetCode discussion - Share my concise JAVA one-pass solution](https://leetcode.com/explore/interview/card/google/60/linked-list-5/1342/discuss/163141/Share-my-concise-JAVA-one-pass-solution)

    There are at most 4 conditions to insert x:

        1. The node which value equals with x;
        1. The x value between the values between two nodes;
        1. We reach the biggest value node: the next node value is smaller than previous, but x is greater than the biggest number;
        1. We reach the biggest value node: the next node value is smaller than previous, but x is smaller than the smallest number;

    And if after we finish the loop, we don't find the position to insert x, we just insert it at the previous of the start(I use a boolean flag to check if I find the position).

1. [LeetCode discussion - O(n) runtime Java solution](https://leetcode.com/explore/interview/card/google/60/linked-list-5/1342/discuss/153116/O(n)-runtime-Java-solution)

    Pretty straight forward algorithm. My assumption is that for any sorted integer list and any integer value, there will always be a place to insert the value such that the list remains sorted.

    You know you've reached the node before the point of insertion of value x if one of these conditions is met:

        1. The current value is less than x and the next value is greater than x
        1. The next value is less than the current value (i.e. you've reached the "end" of the sorted listed and are wrapping back to beginning). In this case, you would insert x if it's the biggest value (x >= current node value) or the smallest value (x <= next node value).

    If you iterate over the entire list once and still haven't found a point of insertion, then the list must contain just 1 value, so insert the new value anywhere.

    ```java
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node newNode = new Node(insertVal, null);
            newNode.next = newNode;
            return newNode;
        }

        Node current = head;
        boolean inserted = false;

        do {
            if (insertHere(current, insertVal)) {
                Node newNode = new Node(insertVal, current.next);
                current.next = newNode;
                inserted = true;
            }

            current = current.next;
        } while (current != head && !inserted);

        if (current == head) {
            Node newNode = new Node(insertVal, current.next);
            current.next = newNode;
            inserted = true;
        }

        return head;
    }

    private boolean insertHere(Node current, int insertVal) {
        return (current.val <= insertVal && current.next.val >= insertVal)
            || ((current.next.val < current.val) && (insertVal <= current.next.val || insertVal >= current.val));
    }
    ```