package EducativeIo.Courses.GrokkingTheCodingInterview.Ch15_KWayMerge.P2_KthSmallestNumberInMSortedLists._Variants.P2_MergeKSortedArrays.Java;

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
        List<Integer> result = merge(lists);
        // 1, 2, 3, 3, 4, 6, 6, 7, 8
        System.out.print(result);
    }

    public static List<Integer> merge(List<Integer[]> lists) {
        List<Integer> result = new ArrayList<>();
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
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            result.add(lists.get(node.arrayIndex)[node.elementIndex]);
            node.elementIndex++;
            if (lists.get(node.arrayIndex).length > node.elementIndex) {
                minHeap.add(node);
            }
        }
        return result;
    }
}
