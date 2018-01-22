package InterviewBit.src.Courses.Programming.Level3_TwoPointers.Problems.MultipleArrays.IntersectionOfSortedArrays.Java;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 3, 4, 5, 6};
        int[] B = {3, 3, 5};
        int[] result = intersect(A, B);
        for (int item : result) {
            System.out.print(item + " ");
        }
    }
    
    public static int[] intersect(final int[] A, final int[] B) {
        int i = 0, j = 0;
        int m = A.length;
        int n = B.length;
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (i < m && j < n) {
            if (A[i] < B[j]) {
                i++;
            }
            else if (B[j] < A[i]) {
                j++;
            }
            else {
                result.add(B[j++]);
                i++;
            }
        }
        int[] array = new int[result.size()];
        int k = 0;
        for (Integer item : result) {
            array[k] = item.intValue();
            k++;
        }
        return array;
    }
}