package InterviewBit.src.Courses.Programming.Level8_Graphs.Problems.DepthFirstSearch.LargestDistanceBetweenNodesOfATree.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(-1, 0, 0, 0, 3));
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        List<int[]> arr = new ArrayList<>();

        for (int i = 0; i < A.size(); ++i) {
            arr.add(new int[2]);
        }

        int maxDistance = 0;

        for (int i = A.size() - 1; i > 0; --i) {

            int element = A.get(i);

            int[] parent = arr.get(element);

            int currentLength = arr.get(i)[0] + 1;

            parent[1] = Math.max(parent[1], currentLength + parent[0]);
            parent[0] = Math.max(parent[0], currentLength);
            maxDistance = Math.max(maxDistance, parent[1]);
        }

        return maxDistance == 0 ? 0 : maxDistance;
    }
}