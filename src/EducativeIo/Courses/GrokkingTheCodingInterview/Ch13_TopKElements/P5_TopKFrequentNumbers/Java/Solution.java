package EducativeIo.Courses.GrokkingTheCodingInterview.Ch13_TopKElements.P5_TopKFrequentNumbers.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        List<Integer> result = findTopKFrequentNumbers(new int[] {1, 3, 5, 12, 11, 12, 11}, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = findTopKFrequentNumbers(new int[] {5, 12, 11, 3, 11}, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }

    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        // find the frequency of each number
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();
        for (int n : nums) {
            numFrequencyMap.put(n, numFrequencyMap.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<Map.Entry<Integer, Integer>>(
                        (e1, e2) -> e1.getValue() - e2.getValue());

        // go through all numbers of the numFrequencyMap and push them in the minHeap, which will
        // have
        // top k frequent numbers. If the heap size is more than k, we remove the smallest (top)
        // number
        for (Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // create a list of top k numbers
        List<Integer> topNumbers = new ArrayList<>(k);
        while (!minHeap.isEmpty()) {
            topNumbers.add(minHeap.poll().getKey());
        }
        return topNumbers;
    }
}
