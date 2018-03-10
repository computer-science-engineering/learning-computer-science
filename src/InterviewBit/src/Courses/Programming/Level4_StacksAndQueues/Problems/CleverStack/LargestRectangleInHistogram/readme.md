# Problem Definition

## Description

Given n non-negative integers representing the histogram’s bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

![Largest Rectangle in Histogram: Example 1](1.png)

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

![Largest Rectangle in Histogram: Example 2](2.png)

The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example, given height = [2,1,5,6,2,3], return 10.

## Notes

1. [LeetCode discussion](https://discuss.leetcode.com/topic/7599/o-n-stack-based-java-solution)
1. [GeeksForGeeks post 1](https://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-set-1/)
1. [GeeksForGeeks post 2](https://www.geeksforgeeks.org/largest-rectangle-under-histogram/)
1. [Jackson Gabbard YouTube video](https://www.youtube.com/watch?v=VNbkzsnllsU)

### Explanation

i - 1 - stack.peek():

Let's take the second bar(2) as the example. bar(2) means the bar with height = 2.

When i is at bar(2), the top in stack is bar(6). If we take bar(6) as the current height of the rectangle, we need to find the left and right boundary bar of the rectangle. It is always true that both left and right boundary bar has a height either equal or larger than bar(6).

Right Boundary: bar(2), which i points to now, is the first bar that is lower than bar(6) on its right, so the right boundary is (i - 1).

Left Boundary: bar(5), which is the top in stack after bar(6) is popped, is the first bar that is lower than bar(6) on its left, so the left boundary is (stack.peek() + 1).

Now we have found both left and right boundaries, then let's get the width of the rectangle. The width = index of right boundary - index of left boundary + 1 = (i - 1) - (stack.peek() + 1) + 1 = i - 1 - stack.peek().

Then the area = (height of bar(6)) * (i - 1 - stack.peek()).

Let's move to the next loop. The top in stack now is bar(5), and i points to bar(2). So we pop bar(5) out from the stack and take bar(5)'s height as the rectangle's height.

Right Boundary: bar(2) is the first bar that is lower than bar(5) on its right. Then the right boundary is (i - 1).

Left Boundary: bar(1), which is the top in stack after bar(5) is popped, is the first bar that is lower than bar(5) on its left. So the left boundary is (stack.peek() + 1).

The width = (i - 1) - (stack.peek() + 1) = i - 1 - stack.peek() and area = (height of bar(5)) * (i - 1 - stack.peek())).

There is only bar(1) left in the stack, and it is lower than bar(2), which i points to now. So we continue pushing bars to stack till the height starts to decrease or the end of the histogram. Now the stack has bar(1), bar(2), bar(3) and bar(3) is on the top. i points to the position on the right of bar(3).

We pop bar(3) out of the stack and take its height as the rectangle's height. The right boundary is (i - 1); the left boundary is bar(2) which is (stack.peek() + 1).

Next, pop bar(2) out of the stack and take its height as the rectangle's height. Remember that the boundary's height is either equal or larger than bar(2)'s height. The right boundary is bar(3), which is (i - 1). The left boundary is bar(1)'s right which is (stack.peek() + 1).

What if the stack is empty when looking for the left boundary?

Let's take the example when stack contains bar(1) only. It's obvious that the right boundary is (i - 1). After popping bar(1) out, the stack is empty. It means there is no bar that is lower than bar(1) on its left. So the left boundary is all the way to the left, which is the most left of the histogram with index = 0. Then the width = (i - 1) - 0 + 1 = i. The area = (height of bar(1)) * i.

So the idea is that:

* For each bar, take its height as the rectangle's height. Then find the left and right boundaries of this rectangle.
* (The second top bar in stack) is always the first bar lower than (the top bar in stack) on the left.
* (The bar that i points to) is always the first bar lower than (the top bar in stack) on the right.
* After step 2 and 3, we know the left and right boundaries, then know the width, then know the area.

[Ref](https://discuss.leetcode.com/post/223558)