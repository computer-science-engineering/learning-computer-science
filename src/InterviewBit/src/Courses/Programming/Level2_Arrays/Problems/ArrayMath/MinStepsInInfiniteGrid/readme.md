# Problem Definition

## Description

You are in an infinite 2D grid where you can move in any of the 8 directions :

```text
(x, y) to
(x+1, y),
(x-1, y),
(x, y+1),
(x, y-1),
(x-1, y-1),
(x+1, y+1),
(x-1, y+1),
(x+1, y-1)
```

You are given a sequence of points and **the order in which you need to cover the points**. Give the minimum number of steps in which you can achieve it. You start from the first point.

**Example :**

```text
Input : [(0, 0), (1, 1), (1, 2)]
Output : 2
```

It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).

This question is intentionally left slightly vague. Clarify the question by trying out a few cases in the “See Expected Output” section.

## Notes

Note that because the order of covering the points is already defined, the problem just reduces to figuring out the way to calculate the distance between 2 points (A, B) and (C, D).

Note that what only matters is X = abs(A-C) and Y = abs(B-D).

While X and Y are positive, you will move along the diagonal and X and Y would both reduce by 1.

When one of them becomes 0, you would move so that in each step the remaining number reduces by 1.

In other words, the total number of steps would correspond to max(X, Y).