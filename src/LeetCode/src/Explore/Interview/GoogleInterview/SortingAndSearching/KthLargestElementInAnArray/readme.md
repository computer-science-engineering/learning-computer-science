# Problem Definition

## Description

Find the **k**th largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

**Example 1:**

```text
Input: [3,2,1,5,6,4] and k = 2
Output: 5
```

**Example 2:**

```text
Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
```

**Note:**

You may assume k is always valid, 1 ≤ k ≤ array's length.

## Notes

1. [LeetCode discussion - AC Clean QuickSelect Java solution avg. O(n) time](https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/361/discuss/60312/AC-Clean-QuickSelect-Java-solution-avg.-O(n)-time)

    ```java
    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1, index = nums.length - k;
        while (start < end) {
            int pivot = partition(nums, start, end);
            if (pivot < index) start = pivot + 1;
            else if (pivot > index) end = pivot - 1;
            else return nums[pivot];
        }
        return nums[start];
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = start, temp;
        while (start <= end) {
            while (start <= end && nums[start] <= nums[pivot]) start++;
            while (start <= end && nums[end] > nums[pivot]) end--;
            if (start > end) break;
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        temp = nums[end];
        nums[end] = nums[pivot];
        nums[pivot] = temp;
        return end;
    }
    ```

1. [QuickSelect algorithm](https://en.wikipedia.org/wiki/Quickselect)
1. [LeetCode discussion - Solution explained](https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/361/discuss/60294/Solution-explained)

    **O(N lg N) running time + O(1) memory**

    ```java
    The simplest approach is to sort the entire input array and then access the element by it's index (which is O(1)) operation:

    public int findKthLargest(int[] nums, int k) {
            final int N = nums.length;
            Arrays.sort(nums);
            return nums[N - k];
    }
    ```

    **O(N lg K) running time + O(K) memory**

    Other possibility is to use a min oriented priority queue that will store the K-th largest values. The algorithm iterates over the whole input and maintains the size of priority queue.

    ```java
    public int findKthLargest(int[] nums, int k) {

        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : nums) {
            pq.offer(val);

            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
    ```

    **O(N) best case / O(N^2) worst case running time + O(1) memory**

    The smart approach for this problem is to use the selection algorithm (based on the partition method - the same one as used in quicksort).

    ```java
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        while(true) {
            while(i < hi && less(a[++i], a[lo]));
            while(j > lo && less(a[lo], a[--j]));
            if(i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(int v, int w) {
        return v < w;
    }
    ```

    **O(N) guaranteed running time + O(1) space**

    So how can we improve the above solution and make it O(N) guaranteed? The answer is quite simple, we can randomize the input, so that even when the worst case input would be provided the algorithm wouldn't be affected. So all what it is needed to be done is to shuffle the input.

    ```java
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private void shuffle(int a[]) {

        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            exch(a, ind, r);
        }
    }
    ```

    There is also worth mentioning the Blum-Floyd-Pratt-Rivest-Tarjan algorithm that has a guaranteed O(N) running time.

1. LeetCode submission - 1 ms

    ```java
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length,target=n-k;
        quickSort(nums,0,n-1,target);
        return nums[target];
    }

    public void quickSort(int[] nums,int start,int end,int target){
        if(start==end) return;
        int mid=(start+end)/2;
        int pivot=findPivot(nums[start],nums[mid],nums[end]);
        int i=start,j=end;
        while(i<=j){
            while(nums[i]<pivot) i++;
            while(nums[j]>pivot) j--;
            if(i<=j){
                swap(nums,i,j);
                i++;
                j--;
            }
        }
        if(target<=i-1) quickSort(nums,start,i-1,target);
        else{
            quickSort(nums,i,end,target);
        }
    }

    public int findPivot(int a,int b, int c){
        int max=Math.max(Math.max(a,b),c);
        int min=Math.min(Math.min(a,b),c);
        return a+b+c-max-min;
    }

    public void swap(int[] nums, int i, int j){
        if(i==j) return;
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    ```