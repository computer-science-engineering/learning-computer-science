# Problem Definition

## Description

Given a robot cleaner in a room modeled as a grid.

Each cell in the grid can be empty or blocked.

The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.

When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.

Design an algorithm to clean the entire room using only the 4 given APIs shown below.

```text
interface Robot {
  // returns true if next cell is open and robot moves into the cell.
  // returns false if next cell is obstacle and robot stays on the current cell.
  boolean move();

  // Robot will stay on the same cell after calling turnLeft/turnRight.
  // Each turn will be 90 degrees.
  void turnLeft();
  void turnRight();

  // Clean the current cell.
  void clean();
}
```

**Example:**

```text
**Input:**

room = [
  [1,1,1,1,1,0,1,1],
  [1,1,1,1,1,0,1,1],
  [1,0,1,1,1,1,1,1],
  [0,0,0,1,0,0,0,0],
  [1,1,1,1,1,1,1,1]
],
row = 1,
col = 3

**Explanation:**

All grids in the room are marked by either 0 or 1.
0 means the cell is blocked, while 1 means the cell is accessible.
The robot initially starts at the position of row=1, col=3.
From the top left corner, its position is one row below and three columns right.
```

**Notes:**

1. The input is only given to initialize the room and the robot's position internally. You must solve this problem "blindfolded". In other words, you must control the robot using only the mentioned 4 APIs, without knowing the room layout and the initial robot's position.
2. The robot's initial position will always be in an accessible cell.
3. The initial direction of the robot will be facing up.
4. All accessible cells are connected, which means the all cells marked as 1 will be accessible by the robot.
5. Assume all four edges of the grid are all surrounded by wall.

## Notes

1. [LeetCode discussion - Very easy to understand Java solution](https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/1340/discuss/139057/Very-easy-to-understand-Java-solution)
1. [LeetCode discussion - Java DFS Solution with Detailed Explanation and 6ms (99%) Solution](https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/1340/discuss/151942/Java-DFS-Solution-with-Detailed-Explanation-and-6ms-(99)-Solution)
1. [LeetCode discussion - 9ms Java with Explanations](https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/1340/discuss/153530/9ms-Java-with-Explanations)