# Problem Definition

## Description

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

![alt text](https://assets.leetcode.com/uploads/2018/10/22/rainwatertrap.png)

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

**Example:**

```plaintext
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
```

## Notes

1. [LeetCode discussion - Share my short solution.](https://leetcode.com/explore/interview/card/google/59/array-and-strings/341/discuss/17391/Share-my-short-solution.)

    ```java
    public int trap(int[] A){
        int a=0;
        int b=A.length-1;
        int max=0;
        int leftmax=0;
        int rightmax=0;
        while(a<=b){
            leftmax=Math.max(leftmax,A[a]);
            rightmax=Math.max(rightmax,A[b]);
            if(leftmax<rightmax){
                max+=(leftmax-A[a]); // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
                a++;
            }
            else{
                max+=(rightmax-A[b]);
                b--;
            }
        }
        return max;
    }
    ```

1. [LeetCode discussion - A stack based solution for reference, inspired by Histogram](https://leetcode.com/explore/interview/card/google/59/array-and-strings/341/discuss/17414/A-stack-based-solution-for-reference-inspired-by-Histogram)

    ```java
    public int trap(int[] A) {
        if (A==null) return 0;
        Stack<Integer> s = new Stack<Integer>();
        int i = 0, maxWater = 0, maxBotWater = 0;
        while (i < A.length){
            if (s.isEmpty() || A[i]<=A[s.peek()]){
                s.push(i++);
            }
            else {
                int bot = s.pop();
                maxBotWater = s.isEmpty()? // empty means no il
                0:(Math.min(A[s.peek()],A[i])-A[bot])*(i-s.peek()-1);
                maxWater += maxBotWater;
            }
        }
        return maxWater;
    }
    ```

1. [LeetCode discussion - Sharing my Java code: O(n) time, O(1) space](https://leetcode.com/explore/interview/card/google/59/array-and-strings/341/discuss/17386/Sharing-my-Java-code:-O(n)-time-O(1)-space)

    Traverse one pass with two pointers, from two sides to the middle.

    ```java
    public int trap(int[] A) {
        if (A.length < 3) return 0;

        int ans = 0;
        int l = 0, r = A.length - 1;

        // find the left and right edge which can hold water
        while (l < r && A[l] <= A[l + 1]) l++;
        while (l < r && A[r] <= A[r - 1]) r--;

        while (l < r) {
            int left = A[l];
            int right = A[r];
            if (left <= right) {
                // add volume until an edge larger than the left edge
                while (l < r && left >= A[++l]) {
                    ans += left - A[l];
                }
            } else {
                // add volume until an edge larger than the right volume
                while (l < r && A[--r] <= right) {
                    ans += right - A[r];
                }
            }
        }
        return ans;
    }
    ```

1. [LeetCode solution](https://leetcode.com/problems/trapping-rain-water/solution/)
1. [YT Video - GoodTecher - LeetCode Tutorial 42. Trapping Rain Water](https://www.youtube.com/watch?v=wz00uI9mDXA)