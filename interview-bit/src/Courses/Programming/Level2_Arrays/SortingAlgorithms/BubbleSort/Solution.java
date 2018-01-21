package Courses.Programming.Level2_Arrays.SortingAlgorithms.BubbleSort;

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
        ArrayList<Integer> result = bubbleSort(input);
        scan.close();
        System.out.println(result);
    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> input) {
        int n = input.size();
        for(int i=1; i<n; i++) {
            int flag = 0;
            for(int j=0; j<n-1; j++) {
                if(input.get(j) > input.get(j+1)) {
                    Collections.swap(input, j, j+1);
                    flag=1;
                }
            }
            if (flag==0) {
                break;
            }
        }
        return input;
    }
}