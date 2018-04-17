package InterviewBit.src.Courses.Programming.Level2_Arrays.SortingAlgorithms.SelectionSort.Java;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<Integer>();
        input.add(7);
        input.add(2);
        input.add(4);
        input.add(1);
        input.add(5);
        input.add(3);
        input.add(8);
        ArrayList<Integer> result = selectionSort(input);
        System.out.println(result);
    }

    public static ArrayList<Integer> selectionSort(ArrayList<Integer> input) {
        int n = input.size();
        for(int i=0; i<n-1; i++) {
            int iMin = i;
            for(int j=i+1; j<n; j++) {
                if(input.get(j) < input.get(iMin)) {
                    iMin = j;
                }
            }
            int temp = input.get(i);
            input.set(i, input.get(iMin));
            input.set(iMin, temp);
        }
        return input;
    }
}