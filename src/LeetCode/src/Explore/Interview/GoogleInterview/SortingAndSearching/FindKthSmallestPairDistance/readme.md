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
1. [YT Video - GeeksForGeeks - k-th smallest absolute difference of two elements in an array | GeeksForGeeks](https://www.youtube.com/watch?v=ZXpYPeRE66E)