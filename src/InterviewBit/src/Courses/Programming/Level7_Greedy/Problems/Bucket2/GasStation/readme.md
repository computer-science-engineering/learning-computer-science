# Problem Definition

## Description

There are `N` gas stations along a circular route, where the amount of gas at station `i` is `gas[i]`.

You have a car with an unlimited gas tank and it costs `cost[i]` of gas to travel from station `i` to its next station `(i+1)`. You begin the journey with an empty tank at one of the gas stations.

Return the minimum starting gas station’s index if you can travel around the circuit once, otherwise return `-1`.

You can only travel in one direction. `i to i+1, i+2, ... n-1, 0, 1, 2..`
Completing the circuit means starting at `i` and ending up at `i` again.

**Example:**

```text
Input:
      Gas :   [1, 2]
      Cost :  [2, 1]

Output: 1

If you start from index 0, you can fill in gas[0] = 1 amount of gas. Now your tank has 1 unit of gas. But you need cost[0] = 2 gas to travel to station 1.
If you start from index 1, you can fill in gas[1] = 2 amount of gas. Now your tank has 2 units of gas. You need cost[1] = 1 gas to get to station 0. So, you travel to station 0 and still have 1 unit of gas left over. You fill in gas[0] = 1 unit of additional gas, making your current gas = 2. It costs you cost[0] = 2 to get to station 1, which you do and complete the circuit.
```

## Notes

1. [SO post](https://stackoverflow.com/questions/2286849/algorithm-for-truck-moving-around-a-circle-of-gas-stations)

    * if the total gas > cost, there must be a start index to finish the circle, else there isn't.
    * as to an index i, if from i, j is the first index that we cannot reach, then any index from i to j, cannot be the start index.

1. [LeetCode discussion - Share some of my ideas.](https://leetcode.com/problems/gas-station/discuss/42568/Share-some-of-my-ideas.)

    The reason why I think this works:
    * if sum of gas is more than sum of cost, then there must be a solution. And the question guaranteed that the solution is unique(The first one I found is the right one).
    * The tank should never be negative, so restart whenever there is a negative number.

1. [roy3221 GitBook](https://roy3221.gitbooks.io/algorithms/content/ch8_greedy/leetcode_134_gas_station.html)