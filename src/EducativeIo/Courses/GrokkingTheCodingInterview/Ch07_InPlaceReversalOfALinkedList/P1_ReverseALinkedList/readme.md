# Problem Definition

## Description

Given the head of a Singly LinkedList, reverse the LinkedList. Write a function to return the new head of the reversed LinkedList.

## Notes

To reverse a LinkedList, we need to reverse one node at a time. We will start with a variable `current` which will initially point to the head of the LinkedList and a variable `previous` which will point to the previous node that we have processed; initially `previous` will point to `null`.

In a stepwise manner, we will reverse the `current` node by pointing it to the `previous` before moving on to the next node. Also, we will update the `previous` to always point to the previous node that we have processed. The visual representation of the algorithm is as shown below.

```plantuml
@startuml
current -> [2]
[2] -> [4]
[4] -> [6]
[6] -> [8]
[8] -> [10]
note left of current
current = head
end note
note bottom of [2]
previous = null
end note
@enduml
```

```plantuml
@startuml
component null1 [
    null
    ]
component null2 [
    null
    ]
[null1] <- [2]
[2] <- previous
current -> [4]
[4] -> [6]
[6] -> [8]
[8] -> [10]
[10] -> [null2]
@enduml
```

```plantuml
@startuml
component null1 [
    null
    ]
component null2 [
    null
    ]
[null1] <- [2]
[2] <- [4]
[4] <- previous
current -> [6]
[6] -> [8]
[8] -> [10]
[10] -> [null2]
@enduml
```

```plantuml
@startuml
component null1 [
    null
    ]
component null2 [
    null
    ]
[null1] <- [2]
[2] <- [4]
[4] <- [6]
[6] <- previous
current -> [8]
[8] -> [10]
[10] -> [null2]
@enduml
```

```plantuml
@startuml
component null1 [
    null
    ]
component null2 [
    null
    ]
[null1] <- [2]
[2] <- [4]
[4] <- [6]
[6] <- [8]
[8] <- previous
current -> [10]
[10] -> [null2]
@enduml
```

```plantuml
@startuml
component null1 [
    null
    ]
component null2 [
    null
    ]
[null1] <- [2]
[2] <- [4]
[4] <- [6]
[6] <- [8]
[8] <- [10]
[10] <- previous
current -> [null2]
@enduml
```

```plantuml
@startuml
[null] <- [2]
[2] <- [4]
[4] <- [6]
[6] <- [8]
[8] <- [10]
[10] <- head
@enduml
```

### Time Complexity

The time complexity of our algorithm will be O(N) where ‘N’ is the total number of nodes in the LinkedList.

### Space Complexity

We only used constant space, therefore, the space complexity of our algorithm is O(1).

## References
