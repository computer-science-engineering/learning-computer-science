# Problem Definition

## Description

Given an integer array, return the k-th smallest **distance** among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.

**Example 1:**

```text
Input:
nums = [1,3,1]
k = 1
Output: 0
Explanation:
Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.
```

**Note:**

1. `2 <= len(nums) <= 10000`.
2. `0 <= nums[i] < 1000000`.
3. `1 <= k <= len(nums) * (len(nums) - 1) / 2`.

## Notes

1. [LeetCode discussion - Approach the problem using the "trial and error" algorithm](https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/439/discuss/109082/Approach-the-problem-using-the-"trial-and-error"-algorithm)
1. [LeetCode discussion - Java solution, Binary Search](https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/439/discuss/109075/Java-solution-Binary-Search)
1. [LeetCode discussion - Java very Easy and Short(15 lines Binary Search and Bucket Sort) solutions](https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/439/discuss/109094/Java-very-Easy-and-Short(15-lines-Binary-Search-and-Bucket-Sort)-solutions)

    **Bucket Sort Solution**

    ```java
    public int smallestDistancePair(int[] nums, int k) {
        int len=nums.length;
        int len2=1000000;
        int[] dp= new int[len2];
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
            int dif= Math.abs(nums[i]-nums[j]);
            dp[dif]++;
            }
        }
        int sum=0;
        for(int i=0;i<len2;i++){
            sum+=dp[i];
            if(sum>=k) return i;
        }
        return 0;
    }
    ```

    **Binary Search Solution**

    ```java
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, low = 0, hi = nums[n-1] - nums[0];
        while (low < hi) {
            int cnt = 0, j = 0, mid = (low + hi)/2;
            for (int i = 0; i < n; ++i) {
                while (j < n && nums[j] - nums[i] <= mid) ++j;
                cnt += j - i-1;
            }
            if (cnt >= k)
                hi = mid;

            else low = mid + 1;
        }

        return low;
    }
    ```

1. [LeetCode solution](https://leetcode.com/problems/find-k-th-smallest-pair-distance/solution/)
1. [Geeks for Geeks - k-th smallest absolute difference of two elements in an array](https://www.geeksforgeeks.org/k-th-smallest-absolute-difference-two-elements-array/)

    Sort the given array `a[]`.

    We can easily find the least possible absolute difference in O(n) after sorting. The largest possible difference will be `a[n-1] - a[0]` after sorting the array.

    ```text
    Let low = minimum_difference and high = maximum_difference.
    while low < high:
        mid = (low + high)/2
        if ((number of pairs with absolute difference
                                    <= mid) < k):
           low = mid + 1
        else:
           high = mid
    return low
    ```

    We need a function that will tell us number of pairs with difference <= mid efficiently. Since our array is sorted, this part can be done like this:

    ```text
    result = 0
    for i = 0 to n-1:
        result = result + (upper_bound(a+i, a+n, a[i] + mid) - (a+i+1))
    return result
    ```

    Here upper_bound is a variant of binary search which returns a pointer to the first element from `a[i] to a[n-1]` which is greater than `a[i] + mid`. Let the pointer returned be `j`. Then `a[i] + mid < a[j]`. Thus, subtracting `(a+i+1)` from this will give us the number of values whose difference with `a[i]` is `<= mid`. We sum this up for all indices from `0` to `n-1` and get the answer for current mid.

1. [YT Video - GeeksForGeeks - k-th smallest absolute difference of two elements in an array | GeeksForGeeks](https://www.youtube.com/watch?v=ZXpYPeRE66E)
1. LeetCode sample submission - 5 ms

    ```java
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        int lo = 0;
        int hi = nums[n - 1] - nums[0];
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int left = 0;
            int count = 0;
            for (int right = 0; right < n; right++) {
                while (nums[right] - nums[left] > mid) left++;
                count += (right - left);
            }
            if (count >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    ```