# Problem Definition

## Description

Given the head of a Singly LinkedList and a number ‘k’, rotate the LinkedList to the right by ‘k’ nodes.

Example 1:

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
[6] -> [null]
@enduml
```

```plantuml
@startuml
note top of head
k = 3
Rotated LinkedList
end note
head -> [4]
[4] -> [5]
[5] -> [6]
[6] -> [1]
[1] -> [2]
[2] -> [3]
[3] -> [null]
component [4] #lightgreen
component [5] #lightgreen
component [6] #lightgreen
component [1] #orange
component [2] #orange
component [3] #orange
@enduml
```

Example 2:

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
[5] -> [null]
@enduml
```

```plantuml
@startuml
note top of head
k = 8
Rotated LinkedList
end note
head -> [3]
[3] -> [4]
[4] -> [5]
[5] -> [1]
[1] -> [2]
[2] -> [null]
component [3] #lightgreen
component [4] #lightgreen
component [5] #lightgreen
component [1] #lightgreen
component [2] #lightgreen
@enduml
```

## Notes

Another way of defining the rotation is to take the sub-list of ‘k’ ending nodes of the LinkedList and connect them to the beginning. Other than that we have to do three more things:

1. Connect the last node of the LinkedList to the head, because the list will have a different tail after the rotation.
2. The new head of the LinkedList will be the node at the beginning of the sub-list.
3. The node right before the start of sub-list will be the new tail of the rotated LinkedList.

### Time Complexity

The time complexity of our algorithm will be O(N) where ‘N’ is the total number of nodes in the LinkedList.

### Space Complexity

We only used constant space, therefore, the space complexity of our algorithm is O(1).

## References
