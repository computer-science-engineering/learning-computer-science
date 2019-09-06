# Problem Definition

## Description

You are given two integer arrays **nums1** and **nums2** sorted in ascending order and an integer **k**.

Define a pair **(u,v)** which consists of one element from the first array and one element from the second array.

Find the k pairs **(u1,v1),(u2,v2) ...(uk,vk)** with the smallest sums.

**Example 1:**

```plaintext
Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence:
             [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
```

**Example 2:**

```plaintext
Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [1,1],[1,1]
Explanation: The first 2 pairs are returned from the sequence:
             [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
```

**Example 3:**

```plaintext
Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [1,3],[2,3]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
```

## Notes

1. [Geeks for Geeks - Find k pairs with smallest sums in two arrays](https://www.geeksforgeeks.org/find-k-pairs-smallest-sums-two-arrays/)
1. [LeetCode discussion - simple Java O(KlogK) solution with explanation](leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/447/discuss/84551/simple-Java-O(KlogK)-solution-with-explanation/150089)

    ![image](https://cloud.githubusercontent.com/assets/8743900/17332795/0bb46cfe-589e-11e6-90b5-5d3c9696c4f0.png)

    [Essentially a multiple-way merge sort](leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/447/discuss/84551/simple-Java-O(KlogK)-solution-with-explanation/150163):

    ![image](https://pbs.twimg.com/media/Dg-5jocU0AAI-cC.jpg:small)

1. [LeetCode discussion - Java 10ms solution no priority queue](https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/447/discuss/84611/Java-10ms-solution-no-priority-queue)

    ```java
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ret = new ArrayList<int[]>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return ret;
        }

        int[] index = new int[nums1.length];
        while (k-- > 0) {
            int min_val = Integer.MAX_VALUE;
            int in = -1;
            for (int i = 0; i < nums1.length; i++) {
                if (index[i] >= nums2.length) {
                    continue;
                }
                if (nums1[i] + nums2[index[i]] < min_val) {
                    min_val = nums1[i] + nums2[index[i]];
                    in = i;
                }
            }
            if (in == -1) {
                break;
            }
            int[] temp = {nums1[in], nums2[index[in]]};
            ret.add(temp);
            index[in]++;
        }
        return ret;
    }
    ```

1. LeetCode sample submission - 3 ms

    ```java
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1.length == 0 || nums2.length ==0){
            return new ArrayList<int[]>();
        }
        if(k > nums1.length * nums2.length)
            k = nums1.length * nums2.length;
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        for(int i = 0; i < Math.min(k, nums1.length); i++){
            pq.add(new Node(new int[]{i, 0}, nums1[i]+nums2[0]));
        }
        ArrayList<int[]> res = new ArrayList<int[]>();
        while(res.size() < k){
            Node curr = pq.poll();
            res.add(new int[]{nums1[curr.idx[0]], nums2[curr.idx[1]]});
            if(curr.idx[1] +1 < nums2.length){
                pq.add(new Node(new int[]{curr.idx[0], curr.idx[1] +1}, nums1[curr.idx[0]]+nums2[curr.idx[1] +1]));
            }
        }
        return res;
    }
    ```