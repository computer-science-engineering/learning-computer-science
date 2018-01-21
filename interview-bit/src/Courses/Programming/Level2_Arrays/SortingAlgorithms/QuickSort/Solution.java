package Courses.Programming.Level2_Arrays.SortingAlgorithms.QuickSort;

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
        ArrayList<Integer> result = quickSort(input, 0, input.size()-1);
        scan.close();
        System.out.println(result);
    }

    public static ArrayList<Integer> quickSort(ArrayList<Integer> input, int start, int end) {
        if (start<end){
            int pIndex = partition(input, start, end);
            quickSort(input, start, pIndex-1);
            quickSort(input, pIndex+1, end);
        }
        return input;
    }

    public static int partition(ArrayList<Integer> input, int start, int end) {
        int pivot = input.get(end);
        int pIndex = start;
        for(int i=start; i<=end-1; i++){
            if (input.get(i) <= pivot) {
                Collections.swap(input, i, pIndex);
                pIndex++;
            }
        }
        Collections.swap(input, pIndex, end);
        return pIndex;
    }
}