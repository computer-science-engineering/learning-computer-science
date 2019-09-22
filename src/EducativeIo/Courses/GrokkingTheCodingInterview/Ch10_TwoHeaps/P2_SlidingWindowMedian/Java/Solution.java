package EducativeIo.Courses.GrokkingTheCodingInterview.Ch10_TwoHeaps.P2_SlidingWindowMedian.Java;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        double[] result = solution.findSlidingWindowMedian(new int[] {1, 2, -1, 3, 5}, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        solution = new Solution();
        result = solution.findSlidingWindowMedian(new int[] {1, 2, -1, 3, 5}, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }

    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (maxHeap.size() == 0 || maxHeap.peek() >= nums[i]) {
                maxHeap.add(nums[i]);
            } else {
                minHeap.add(nums[i]);
            }
            rebalanceHeaps();

            if (i - k + 1 >= 0) { // if we have at least 'k' elements in the sliding window
                // add the median to the the result array
                if (maxHeap.size() == minHeap.size()) {
                    // we have even number of elements, take the average of middle two elements
                    result[i - k + 1] = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
                } else { // because max-heap will have one more element than the min-heap
                    result[i - k + 1] = maxHeap.peek();
                }

                // remove the the element going out of the sliding window
                int elementToBeRemoved = nums[i - k + 1];
                if (elementToBeRemoved <= maxHeap.peek()) {
                    maxHeap.remove(elementToBeRemoved);
                } else {
                    minHeap.remove(elementToBeRemoved);
                }
                rebalanceHeaps();
            }
        }
        return result;
    }

    private void rebalanceHeaps() {
        // either both the heaps will have equal number of elements or max-heap will have
        // one more element than the min-heap
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
}
