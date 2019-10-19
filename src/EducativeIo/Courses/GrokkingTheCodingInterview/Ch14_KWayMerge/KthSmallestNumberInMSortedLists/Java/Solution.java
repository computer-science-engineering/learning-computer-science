package EducativeIo.Courses.GrokkingTheCodingInterview.Ch14_KWayMerge.KthSmallestNumberInMSortedLists.Java;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Integer[] l1 = new Integer[] {2, 6, 8};
        Integer[] l2 = new Integer[] {3, 6, 7};
        Integer[] l3 = new Integer[] {1, 3, 4};
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int result = findKthSmallest(lists, 5);
        System.out.print("Kth smallest number is: " + result);
    }

    public static int findKthSmallest(List<Integer[]> lists, int k) {
        PriorityQueue<Node> minHeap =
                new PriorityQueue<Node>((n1, n2) -> lists.get(n1.arrayIndex)[n1.elementIndex]
                        - lists.get(n2.arrayIndex)[n2.elementIndex]);

        // put the 1st element of each array in the min heap
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                minHeap.add(new Node(0, i));
            }
        }

        // take the smallest (top) element form the min heap, if the running count is equal to k
        // return the number
        // if the array of the top element has more elements, add the next element to the heap
        int numberCount = 0, result = 0;
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            result = lists.get(node.arrayIndex)[node.elementIndex];
            if (++numberCount == k) {
                break;
            }
            node.elementIndex++;
            if (lists.get(node.arrayIndex).length > node.elementIndex) {
                minHeap.add(node);
            }
        }
        return result;
    }
}
