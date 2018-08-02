# Problem Definition

## Description

Given *n* points on a 2D plane, find the maximum number of points that lie on the same straight line.

**Example 1:**

```text
Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o  
+------------->
0  1  2  3  4
```

**Example 2:**

```text
Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6
```

## Notes

1. [LeetCode discussion](https://leetcode.com/problems/max-points-on-a-line/discuss/47113/A-java-solution-with-notes)

    line is determined by two factors,say y=ax+b

    If two points(x1,y1) (x2,y2) are on the same line(Of course).

    Consider the gap between two points.

    We have (y2-y1)=a(x2-x1),a=(y2-y1)/(x2-x1) a is a rational, b is canceled since b is a constant

    If a third point (x3,y3) are on the same line. So we must have y3=ax3+b

    Thus,(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a

    Since a is a rational, there exists y0 and x0, y0/x0=(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a

    So we can use y0&x0 to track a line;
