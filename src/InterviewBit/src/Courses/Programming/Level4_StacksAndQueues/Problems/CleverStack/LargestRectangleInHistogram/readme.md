# Largest Rectangle In Histogram

## Link

[Here](https://www.interviewbit.com/problems/largest-rectangle-in-histogram/)

## Description

Given n non-negative integers representing the histogram’s bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

![Largest Rectangle in Histogram: Example 1](1.png)

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

![Largest Rectangle in Histogram: Example 2](2.png)

The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example, given height = [2,1,5,6,2,3], return 10.

## Companies asked in

1. Google
1. Facebook

## Notes

1. [LeetCode discussion](https://discuss.leetcode.com/topic/7599/o-n-stack-based-java-solution)
1. [GeeksForGeeks post 1](https://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-set-1/)
1. [GeeksForGeeks post 2](https://www.geeksforgeeks.org/largest-rectangle-under-histogram/)

### Why the i--

When we are in the else branch, means the h (height[i]) is smaller than height[s.peek()], what we do is updating the maxArea, but the height[i] is still waiting to be put into the stack, we do i-- to counteract the i++ statement in the for loop, so that we will get the same i in the next time. [ref](https://discuss.leetcode.com/post/123631)