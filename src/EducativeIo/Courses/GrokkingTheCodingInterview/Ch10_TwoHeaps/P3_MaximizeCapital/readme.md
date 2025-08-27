# Problem Definition

## Description

Given a set of investment projects with their respective profits, we need to find the most profitable projects. We will be given an initial capital and allowed to invest only in a fixed number of projects. Our goal is to choose projects that give us the maximum profit.

We can start an investment project only when we have the required capital. Once a project is selected, we can assume that its profit has become our capital.

**Example 1**:

```plaintext
Input: Project Capitals=[0,1,2], Project Profits=[1,2,3], Initial Capital=1, Number of Projects=2
Output: 6

Explanation:

With initial capital of ‘1’, we will start the second project which will give us profit of ‘2’.
Once we selected our first project, our total capital will become 3 (profit + initial capital).
With ‘3’ capital, we will select the third project, which will give us ‘3’ profit.
After the completion of the two projects, our total capital will be 6 (1+2+3).
```

**Example 2**:

```plaintext
Input: Project Capitals=[0,1,2,3], Project Profits=[1,2,3,5], Initial Capital=0, Number of Projects=3
Output: 8

Explanation:

With ‘0’ capital, we can only select the first project, bringing out capital to 1.
Next, we will select the second project, which will bring our capital to 3.
Next, we will select the fourth project, giving us a profit of 5.
After selecting the three projects, our total capital will be 8 (1+2+5).
```

## Discussion

While selecting projects we have two constraints:

1. We can select a project only when we have the required capital.
2. There is a maximum limit on how many projects we can select.

Since we don’t have any time constraint, we should select a project that gives us maximum profit and for which we also have enough capital. Following this greedy approach will give us the best solution.

While selecting a project, we will do two things:

1. Find all the projects that we can choose with the available capital.
2. From the list of projects in the 1st step, choose the project that gives us a maximum profit.

We can follow the **Two Heaps** approach similar to **Find the Median of a Number Stream**. Here are the steps of our algorithm:

1. Add all project capitals to a min-heap, so that we can select a project with the smallest capital requirement.
2. Go through the top projects of the min-heap and filter the projects that can be completed within our available capital. Insert the profits of all these projects into a max-heap, so that we can choose a project with the maximum profit.
3. Finally, select the top project of the max-heap for investment.
4. Repeat the 2nd and 3rd steps for the required number of projects.

### Time Complexity

Since, at the most, all the projects will be pushed to both the heaps once, the time complexity of our algorithm is O(NlogN + KlogN), where ‘N’ is the total number of projects and ‘K’ is the number of projects we are selecting.

### Space Complexity

The space complexity will be O(N) because we will be storing all the projects in the heaps.

## Notes

## References
