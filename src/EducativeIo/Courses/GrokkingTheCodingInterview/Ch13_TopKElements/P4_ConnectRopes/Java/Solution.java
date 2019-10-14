package EducativeIo.Courses.GrokkingTheCodingInterview.Ch13_TopKElements.P4_ConnectRopes.Java;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int result = minimumCostToConnectRopes(new int[] {1, 3, 11, 5});
        System.out.println("Minimum cost to connect ropes: " + result);
        result = minimumCostToConnectRopes(new int[] {1, 3, 11, 5, 2});
        System.out.println("Minimum cost to connect ropes: " + result);
    }

    public static int minimumCostToConnectRopes(int[] ropeLengths) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        // add all ropes to the min heap
        for (int i = 0; i < ropeLengths.length; i++)
            minHeap.add(ropeLengths[i]);

        // go through the values of the heap, in each step take top (lowest) rope lengths from the
        // min heap
        // connect them and push the result back to the min heap.
        // keep doing this until the heap is left with only one rope
        int result = 0, temp = 0;
        while (minHeap.size() > 1) {
            temp = minHeap.poll() + minHeap.poll();
            result += temp;
            minHeap.add(temp);
        }

        return result;
    }
}
