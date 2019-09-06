# Problem Definition

## Description

Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

**Example 1:**

```plaintext
Input: [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
    After flipping, the maximum number of consecutive 1s is 4.
```

**Note:**

* The input array will only contain `0` and `1`.
* The length of input array is a positive integer and will not exceed 10,000.

**Follow up:** What if the input numbers come in one by one as an **infinite stream**? In other words, you can't store all numbers coming from the stream as it's too large to hold in memory. Could you solve it efficiently?

## Notes

1. [LeetCode discussion - Java clean solution easily extensible to flipping k zero and follow-up handled](https://leetcode.com/explore/interview/card/google/59/array-and-strings/455/discuss/96920/Java-clean-solution-easily-extensible-to-flipping-k-zero-and-follow-up-handled)

    The idea is to keep a window `[l, h]` that contains at most `k` zero

    The following solution does not handle follow-up, because `nums[l]` will need to access previous input stream

    `Time: O(n) Space: O(1)`

    ```java
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, zero = 0, k = 1; // flip at most k zero
        for (int l = 0, h = 0; h < nums.length; h++) {
            if (nums[h] == 0) 
                zero++;
            while (zero > k)
                if (nums[l++] == 0)
                    zero--;
            max = Math.max(max, h - l + 1);
        }
        return max;
    }
    ```

    Now let's deal with follow-up, we need to store up to `k` indexes of zero within the window `[l, h]` so that we know where to move `l` next when the window contains more than `k` zero. If the input stream is infinite, then the output could be extremely large because there could be super long consecutive ones. In that case we can use `BigInteger` for all indexes. For simplicity, here we will use `int`

    `Time: O(n) Space: O(k)`

    ```java
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, k = 1; // flip at most k zero
        Queue<Integer> zeroIndex = new LinkedList<>(); 
        for (int l = 0, h = 0; h < nums.length; h++) {
            if (nums[h] == 0)
                zeroIndex.offer(h);
            if (zeroIndex.size() > k)
                l = zeroIndex.poll() + 1;
            max = Math.max(max, h - l + 1);
        }
        return max;
    }
    ```

    Note that setting `k = 0` will give a solution to the earlier version [Max Consecutive Ones](https://leetcode.com/problems/max-consecutive-ones/)

    For `k = 1` we can apply the same idea to simplify the solution. Here `q` stores the index of zero within the window `[l, h]` so its role is similar to `Queue` in the above solution

    ```java
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, q = -1;
        for (int l = 0, h = 0; h < nums.length; h++) {
            if (nums[h] == 0) {
                l = q + 1;
                q = h;
            }
            max = Math.max(max, h - l + 1);
        }
        return max;
    }
    ````

1. [LeetCode discussion - Sliding window+2 pointers,O(n) time 1 pass,O(1) space](https://leetcode.com/explore/interview/card/google/59/array-and-strings/455/discuss/96916/Sliding-window+2-pointersO(n)-time-1-passO(1)-space)

    I learned this from the [decent tutorial by @zjh08177,thank you !!](https://discuss.leetcode.com/topic/30941/here-is-a-10-line-template-that-can-solve-most-substring-problems)

    ```java
    public class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int j=0;
            int len=0;
            int zero=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0){
                    zero++;
                }

                while(zero>1){
                    if(nums[j]==0){
                        zero--;
                    }
                    j++;
                }
                len=Math.max(i-j+1,len);
            }

            return len;
        }
    }
    ```

1. [LeetCode discussion - Easy Java solution](https://leetcode.com/explore/interview/card/google/59/array-and-strings/455/discuss/96966/Easy-Java-solution)

    The result is made of "previous consecutive 1s" + 0 + "current consecutive 1s". Each time a 0 is encountered, the number of "current consecutive 1s" plus 1 becomes the number of "previous consecutive 1s".

    ```java
    public int findMaxConsecutiveOnes(int[] nums) {
        int pre = 0;
        int cur = 0;
        int result = 0;
        for (int num: nums) {
            if (num == 1) {
                cur++;
            } else {
                pre = cur + 1;
                cur = 0;
            }
            result = Math.max(result, cur + pre);
        }
        return result;
    }
    ```

1. [LeetCode discussion - Java Concise O(n) Time O(1) Space](https://leetcode.com/explore/interview/card/google/59/array-and-strings/455/discuss/96929/Java-Concise-O(n)-Time-O(1)-Space)

    ```java
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutive = 0, zeroLeft = 0, zeroRight = 0;
        for (int i=0;i<nums.length;i++) {
            zeroRight++;
            if (nums[i] == 0) {
                zeroLeft = zeroRight;
                zeroRight = 0;
            }
            maxConsecutive = Math.max(maxConsecutive, zeroLeft+zeroRight); 
        }
        return maxConsecutive;
    }
    ```