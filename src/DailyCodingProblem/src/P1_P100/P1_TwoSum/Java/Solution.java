package DailyCodingProblem.src.P1_P100.P1_TwoSum.Java;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] numbers = {10, 15, 3, 7};
        int target = 17;
        System.out.println(twoSum(numbers, target));
    }

    public static boolean twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return false;
        }
        
        HashMap<Integer, Integer>  map = new HashMap<>();
        for (int i=0; i<numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                return true;
            }
            else {
                map.put(target - numbers[i], i);
            }
        }

        return false;
    }
}