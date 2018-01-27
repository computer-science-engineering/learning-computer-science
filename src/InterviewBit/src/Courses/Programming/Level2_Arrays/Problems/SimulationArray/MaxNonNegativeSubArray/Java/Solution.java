package InterviewBit.src.Courses.Programming.Level2_Arrays.Problems.SimulationArray.MaxNonNegativeSubArray.Java;

import java.util.*;

public class Solution {
    public static void main(String[] args) {    
        int[] input = {1967513926, 1540383426, -1303455736, -521595368};
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int var : input) {
            a.add(var);
        }
        System.out.println(maxset(a));
    }    

    public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
        long maxSum = 0;
        long newSum = 0;
        ArrayList<Integer> maxArray = new ArrayList<Integer>();
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        for (Integer i : a) {
            if (i >= 0) {
                newSum += i;
                newArray.add(i);
            } else {
                newSum = 0;
                newArray = new ArrayList<Integer>();
            }
            if ((maxSum < newSum) || ((maxSum == newSum) && (newArray.size() > maxArray.size()))) {
                maxSum = newSum;
                maxArray = newArray;
            }
        }
        return maxArray;
    }
}