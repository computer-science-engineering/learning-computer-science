# Problem Definition

## Description

Given two arrays, write a function to compute their intersection.

**Example:**

Given nums1 = `[1, 2, 2, 1]`, nums2 = `[2, 2]`, return `[2, 2]`.

**Note:**

Each element in the result should appear as many times as it shows in both arrays. The result can be in any order.

**Follow up:**

* What if the given array is already sorted? How would you optimize your algorithm?
* What if nums1's size is small compared to nums2's size? Which algorithm is better?
* What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

## Notes

1. [LeetCode discussion - Java Solution Using a HashMap](https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/discuss/143105/Java-Solution-Using-a-HashMap)
1. LeetCode sample submission - 1 ms

    ```java
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int k=0;
        int i=0;
        int j=0;

        while (i<nums1.length && j<nums2.length) {
            if (nums1[i] == nums2[j]) {
                result[k] = nums1[i];
                j++;
                i++;
                k++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        return Arrays.copyOfRange(result, 0, k);
    }
    ```