package EducativeIo.Courses.GrokkingTheCodingInterview.Ch14_TopKElements.P7_KthLargestNumberInAStream.Java;

import java.util.PriorityQueue;

public class Solution {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
    final int k;

    public static void main(String[] args) {
        int[] input = new int[] {3, 1, 5, 12, 2, 11};
        Solution kthLargestNumber = new Solution(input, 4);
        System.out.println("4th largest number is: " + kthLargestNumber.add(6));
        System.out.println("4th largest number is: " + kthLargestNumber.add(13));
        System.out.println("4th largest number is: " + kthLargestNumber.add(4));
    }

    public Solution(int[] nums, int k) {
        this.k = k;
        // add the numbers in the min heap
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int num) {
        // add the new number in the min heap
        minHeap.add(num);

        // if heap has more than 'k' numbers, remove one number
        if (minHeap.size() > this.k) {
            minHeap.poll();
        }

        // return the 'Kth largest number
        return minHeap.peek();
    }
}
