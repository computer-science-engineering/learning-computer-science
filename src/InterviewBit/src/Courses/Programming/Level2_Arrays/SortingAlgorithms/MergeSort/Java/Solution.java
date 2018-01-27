package InterviewBit.src.Courses.Programming.Level2_Arrays.SortingAlgorithms.MergeSort.Java;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> input = new ArrayList<Integer>();
        input.add(7);
        input.add(2);
        input.add(4);
        input.add(1);
        input.add(5);
        input.add(3);
        input.add(8);
        ArrayList<Integer> result = mergeSort(input);
        scan.close();
        System.out.println(result);
    }    

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> input) {
        int n = input.size();
        if (n<2) {
            return input;
        }

        int mid = n/2;
        ArrayList<Integer> left = new ArrayList<Integer>(mid);
        ArrayList<Integer> right = new ArrayList<Integer>(mid);
        for (int i=0; i<=mid-1; i++) {
            left.add(input.get(i));
        }

        for (int i=mid; i<=n-1; i++) {
            right.add(input.get(i));
        }

        left = mergeSort(left);
        right  = mergeSort(right);
        ArrayList<Integer> result = merge(left, right, input);
        return result;
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<Integer> parent) {        
        int lengthOfLeft = left.size();
        int lengthOfRight = right.size();
        int i = 0, j = 0, k = 0;
        while(i<lengthOfLeft && j<lengthOfRight) {
            if (left.get(i) <= right.get(j)) {
                parent.set(k, left.get(i));
                i++;
            }
            else {
                parent.set(k, right.get(j));
                j++;
            }
            k++;
        }
        while(i<lengthOfLeft) {
            parent.set(k, left.get(i));
            i++;
            k++;
        }
        while(j<lengthOfRight) {
            parent.set(k, right.get(j));
            j++;
            k++;
        }
        return parent;
    }
}