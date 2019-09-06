# Problem Definition

## Description

Remove duplicates and return list based on a passed weight. Input list is unsorted. Solve for optimal time complexity.

The weight indicates the number of occurrences. So the output list would have to be sorted based on this weight, i.e., the number of times a number occurs. So, the spot of a number in the list should match the spot at which it occurs as the specified weight. If a number in the list does not occur as many number of times as the weight:

1. if the number of occurrences is less than the weight, the closest will be chosen
1. if the number of occurrences is more than the weight, the spot matching the weight will be chosen and all else subsequently will be ignored.

```plaintext
Example1:

Input: [1, 2, 1, 3, 2, 1]
Output:
n=1 [1, 2, 3]
n=2 [1, 3, 2]
n=3 [3, 2, 1]
```

```plaintext
Example2:

Input: [1, 2, 1, 3, 2, 1, 2]
Output:
n=3 [3, 1, 2]
```

## Notes