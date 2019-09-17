# Problem Definition

## Description

Given the head of a LinkedList and a number ‘k’, **reverse every alternating ‘k’ sized sub-list** starting from the head.

If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.

```plantuml
@startuml
note top of head
Original List
end note
head -> [1]
[1] -> [2]
[2] -> [3]
[3] -> [4]
[4] -> [5]
[5] -> [6]
[6] -> [7]
[7] -> [8]
[8] -> [null]
@enduml
```

```plantuml
@startuml
note top of head
k = 2
Reversed Sub-list
end note
head -> [2]
[2] -> [1]
[1] -> [3]
[3] -> [4]
[4] -> [6]
[6] -> [5]
[5] -> [7]
[7] -> [8]
[8] -> [null]
component [1] #lightgreen
component [2] #lightgreen
component [5] #lightblue
component [6] #lightblue
component [7] #orange
component [8] #orange
@enduml
```

## Notes

The problem follows the **In-place Reversal of a LinkedList** pattern and is quite similar to **Reverse every K-element Sub-list**. The only difference is that we have to skip ‘k’ alternating elements. We can follow a similar approach, and in each iteration after reversing ‘k’ elements, we will skip the next ‘k’ elements.

### Time Complexity

The time complexity of our algorithm is O(N) where ‘N’ is the total number of nodes in the LinkedList.

### Space Complexity

We only used constant space, therefore, the space complexity of our algorithm is O(1).

## References
