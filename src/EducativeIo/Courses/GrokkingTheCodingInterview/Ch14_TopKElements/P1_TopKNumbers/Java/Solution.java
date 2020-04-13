package EducativeIo.Courses.GrokkingTheCodingInterview.Ch14_TopKElements.P1_TopKNumbers.Java;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        List<Integer> result = findKLargestNumbers(new int[] {3, 1, 5, 12, 2, 11}, 3);
        System.out.println("Here are the top K numbers: " + result);

        result = findKLargestNumbers(new int[] {5, 12, 11, -1, 12}, 3);
        System.out.println("Here are the top K numbers: " + result);
    }

    public static List<Integer> findKLargestNumbers(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        // put first 'K' numbers in the min heap
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }

        // go through the remaining numbers of the array, if the number from the array is bigger
        // than the
        // top (smallest) number of the min-heap, remove the top number from heap and add the number
        // from array
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }

        // the heap has the top 'K' numbers, return them in a list
        return new ArrayList<>(minHeap);
    }
}
