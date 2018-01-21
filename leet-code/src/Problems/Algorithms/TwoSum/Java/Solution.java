/*https://leetcode.com/problems/two-sum*/

package Problems.Algorithms.TwoSum.Java;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        int[] input = new int[]{2, 7, 11, 15};
        int[] result = twoSum(input, 9);
        StringBuilder sb = new StringBuilder();
        sb.append(result[0]);
        sb.append(" ");
        sb.append(result[1]);
        System.out.println(sb.toString());
    }

    public static int[] twoSum(int[] numbers, int target) {
        if(numbers==null || numbers.length<2)
            return new int[]{0,0};

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<numbers.length; i++){
            if(map.containsKey(numbers[i])){
                return new int[]{map.get(numbers[i]), i};
            }else{
                map.put(target-numbers[i], i);
            }
        }

        return new int[]{0,0};
    }

}
