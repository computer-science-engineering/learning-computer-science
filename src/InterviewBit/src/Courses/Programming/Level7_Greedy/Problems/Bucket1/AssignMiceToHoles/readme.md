# Problem Definition

## Description

There are `N` mice and `N` holes are placed in a straight line. Each hole can accommodate only 1 mouse. A mouse can stay at his position, move one step right from `x` to `x + 1`, or move one step left from `x` to `x − 1`. Any of these moves consumes 1 minute. Assign mice to holes so that the time when the last mouse gets inside a hole is minimized.

**Example:**

```text
positions of mice are:
4 -4 2
positions of holes are:
4 0 5

Assign mouse at position x=4 to hole at position x=4 : Time taken is 0 minutes
Assign mouse at position x=-4 to hole at position x=0 : Time taken is 4 minutes
Assign mouse at position x=2 to hole at position x=5 : Time taken is 3 minutes
After 4 minutes all of the mice are in the holes.

Since, there is no combination possible where the last mouse's time is less than 4,
answer = 4.
```

**Input:**

```text
A :  list of positions of mice
B :  list of positions of holes
```

**Output:**

```text
single integer value
```

**NOTE:** The final answer will fit in a 32 bit signed integer.

## Notes

1. [Geeks for Geeks - Assign Mice to Holes](https://www.geeksforgeeks.org/assign-mice-holes/)

    We can put every mouse to its nearest hole to minimize the time. This can be done by sorting the positions of mice and holes. This allows us to put the ith mice to the corresponding hole in the holes list. We can then find the maximum difference between the mice and corresponding hole position.