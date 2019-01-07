# Problem Definition

## Description

Given a **sorted** array of integers _nums_ and integer values _a_, _b_ and _c_. Apply a quadratic function of the form f(_x_) = _ax<sup>2</sup>_ + _bx_ + _c_ to each element _x_ in the array.

The returned array must be in **sorted order**.

Expected time complexity: **O(n)**

**Example 1:**

```text
Input: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
Output: [3,9,15,33]
```

**Example 2:**

```text
Input: nums = [-4,-2,2,4], a = -1, b = 3, c = 5
Output: [-23,-5,1,7]
```

## Notes

1. [LeetCode discussion - Java O(n) incredibly short yet easy to understand AC solution](https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/448/discuss/83322/Java-O(n)-incredibly-short-yet-easy-to-understand-AC-solution)

    The problem seems to have many cases a>0, a=0,a<0, (when a=0, b>0, b<0). However, they can be combined into just 2 cases: a>0 or a<0

    1. a>0, two ends in original array are bigger than center if you learned middle school math before.
    2. a<0, center is bigger than two ends.

    So use two pointers i, j and do a merge-sort like process. Depending on sign of a, you may want to start from the beginning or end of the transformed array. For a==0 case, it does not matter what b's sign is. The function is monotonically increasing or decreasing. you can start with either beginning or end.

1. [LeetCode discussion - My easy to understand Java AC solution using Two pointers](https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/448/discuss/83317/My-easy-to-understand-Java-AC-solution-using-Two-pointers)

    The idea is simple: For a parabola,

    * if a >= 0, the min value is at its vertex. So our our sorting should goes from two end points towards the vertex, high to low.
    * if a < 0, the max value is at its vertex. So our sort goes the opposite way.

    ```java
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        int i = a >= 0 ? nums.length - 1 : 0;
        while(start <= end) {
            int startNum = getNum(nums[start], a, b, c);
            int endNum = getNum(nums[end], a, b, c);
            if(a >= 0) {
                if(startNum >= endNum) {
                    res[i--] = startNum;
                    start++;
                }
                else {
                    res[i--] = endNum;
                    end--;
                }
            }
            else {
                if(startNum <= endNum) {
                    res[i++] = startNum;
                    start++;
                }
                else {
                    res[i++] = endNum;
                    end--;
                }
            }
        }
        return res;
    }

    public int getNum(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
    ```

1. [LeetCode discussion - Java O(N) easy, verbose, explained, picture, with math recap](https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/448/discuss/83324/Java-O(N)-easy-verbose-explained-picture-with-math-recap)

    ```java
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums.length == 0 || nums == null)
            return new int[0];
        int n = nums.length;
        int[] res = new int[n];
        if (a == 0) {
            for (int i = 0; i < n; i++) {
                int cur = b >= 0 ? nums[i] : nums[n - 1 - i];
                res[i] = b * cur + c;
            }
            return res;
        }
        //sort based on distance to pivot
        double pivot = (double) -b / (2 * a);
        int[] distSorted = new int[n];
        int lo = 0, hi = n - 1, end = n - 1;
        while (lo <= hi) {
            double d1 = pivot - nums[lo], d2 = nums[hi] - pivot;
            if (d1 > d2) {
                distSorted[end--] = nums[lo++];
            } else {
                distSorted[end--] = nums[hi--];
            }
        }
        //populate res based on distSorted, and also a
        for (int i = 0; i < n; i++) {
            int cur = a > 0 ? distSorted[i] : distSorted[n - 1 - i];
            res[i] = a * cur * cur + b * cur + c;
        }
        return res;
    }
    ```

    ![image](http://i67.tinypic.com/7d0.png)

    The process consists of two procedures:

    1. sort all numbers (`x`s) by their distance to the pivot;
    2. populate the result array (`y`s).

    The code should be easy to understand with the idea explained by the picture.

1. LeetCode sample submission - 4 ms

    ```java
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        int i = 0, j = nums.length - 1;
        int index = a >= 0? nums.length - 1 : 0;
        while (i <= j) {
            int l = cal(a, b, c, nums[i]);
            int r = cal(a, b, c, nums[j]);

            if (a >= 0) {
                if (l > r) {
                    res[index--] = l;
                    i++;
                } else {
                    res[index--] = r;
                    j--;
                }
            } else {
                res[index++] = l > r? r : l;
                if (l > r) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return res;
    }

    public int cal(int a, int b, int c, int x) {
        return a * x * x + b * x + c;
    }
    ```