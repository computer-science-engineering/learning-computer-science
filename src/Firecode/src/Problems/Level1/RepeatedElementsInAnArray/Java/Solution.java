package Firecode.src.Problems.Level1.RepeatedElementsInAnArray.Java;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] numbers = {1,5,23,2,6,3,1,8,12,3};
        System.out.println(duplicate(numbers));
    }

    public static String duplicate(int[] numbers) {
        Arrays.sort(numbers);
        List<Integer> result = new ArrayList<>();
        for (int i=1; i<numbers.length; i++) {
            if (numbers[i] == numbers[i-1]) {
                result.add(numbers[i]);
            }
        }
        return result.toString();
    }
    
    public static String duplicate_naive(int[] numbers) {
        Arrays.sort(numbers);
        HashMap<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int i=0; i<numbers.length; i++) {
            int number = numbers[i];
            if (! occurrences.containsKey(number)) {
                occurrences.put(numbers[i], 1);
            }
            else {
                int soFar = occurrences.get(number);
                occurrences.replace(number, soFar+1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }
        return result.toString();
    }
}