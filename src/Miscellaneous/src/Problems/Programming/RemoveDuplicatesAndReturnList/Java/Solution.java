package Miscellaneous.src.Problems.Programming.RemoveDuplicatesAndReturnList.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2, 1, 3, 2, 1, 2));
        ArrayList<Integer> result = removeDuplicates(input);
        System.out.println(result); // [1, 2, 3]
    }

    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> input) {
        HashMap<Integer, Integer> tracking = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i=0; i<input.size(); i++) {
            if (tracking.containsKey(input.get(i))) {
                // don’t add to result
            }
            else {
                tracking.put(input.get(i), input.get(i));
                result.add(input.get(i));
            }
        }   
        return result;
    }
}