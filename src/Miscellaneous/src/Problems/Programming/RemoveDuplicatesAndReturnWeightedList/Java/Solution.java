package Miscellaneous.src.Problems.Programming.RemoveDuplicatesAndReturnWeightedList.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int weight = 3;
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2, 1, 3, 2, 1));
        ArrayList<Integer> result = removeDuplicates(weight, input);
        System.out.println(result);
    }

    public static ArrayList<Integer> removeDuplicates(int weight, ArrayList<Integer> input) {
        HashMap<Integer, Integer> tracking = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i=0; i<input.size(); i++) {
            if (tracking.containsKey(input.get(i))) {
                int soFarCount = tracking.get(input.get(i));
                if (soFarCount == weight) {
                    result.add(input.get(i));
                }
            }
            else {
                tracking.put(input.get(i), input.get(i));
                result.add(input.get(i));
            }
        }    
        return result;
    }
}