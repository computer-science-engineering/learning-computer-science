package Miscellaneous.src.Problems.Programming.RemoveDuplicatesAndReturnWeightedList.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int weight = 3;
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2, 1, 3, 2, 1, 2));
        ArrayList<Integer> result = removeDuplicates(weight, input);
        System.out.println(result);
    }

    public static ArrayList<Integer> removeDuplicates(int weight, ArrayList<Integer> input) {
        HashMap<Integer, int[]> tracking = new HashMap<Integer, int[]>(); // int[] = [index, soFarCount]
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i=0; i<input.size(); i++) {
            if (tracking.containsKey(input.get(i))) {
                int soFarCount = tracking.get(input.get(i))[1];
                if (soFarCount < weight) {
                    int lastIndex = tracking.get(input.get(i))[0];
                    result.remove(lastIndex);
                    tracking = adjustHashMapIndexes(tracking, lastIndex);
                    result.add(input.get(i));
                    int index = result.size()-1;
                    tracking.put(input.get(i), new int[]{index, soFarCount+1});
                } // else soFarCount >= weight
            }
            else { // first time seen
                result.add(input.get(i));
                int index = result.size()-1;
                tracking.put(input.get(i), new int[]{index, 1});
            }
        }    
        return result;
    }

    private static HashMap<Integer, int[]> adjustHashMapIndexes(HashMap<Integer, int[]> tracking, int removedIndex) {
        HashMap<Integer, int[]> updated = new HashMap<Integer, int[]>();
        tracking.forEach((k,v) -> {
            if (v[0] > removedIndex) {                
                updated.put(k, new int[]{v[0]-1, v[1]});
            } else {
                updated.put(k, v);
            }
        });
        return updated;
    }
}