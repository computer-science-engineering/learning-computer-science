package LeetCode.src.Problems.P401_P500.P464_CanIWin.Java;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int maxChoosableInteger = 10;
        int desiredTotal = 11;
        System.out.println(canIWin(maxChoosableInteger, desiredTotal));
    }

    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal <= maxChoosableInteger) return true;
        int sum = (maxChoosableInteger + 1) * maxChoosableInteger / 2;
        if(sum < desiredTotal) return false;
        return helper(new HashMap<>(), new boolean[maxChoosableInteger + 1], desiredTotal);  
    }
    
    private static boolean helper(Map<Integer, Boolean> dp, boolean[] used, int target) {
        if(target <= 0) return false; 
        int key = hashCode(used);
        if(dp.containsKey(key)) return dp.get(key);
        
        for(int i = 1; i < used.length; i++) {
            if(!used[i]) {
                used[i] = true;
                boolean pre = helper(dp, used, target - i);
                used[i] = false;
                if(!pre) {
                    dp.put(key, true);
                    return true;  
                } 
            }  
        }
        dp.put(key, false);  
        return false;  
    }
    
    private static int hashCode(boolean[] used){
        int num = 0;
        for(boolean b: used) {
            if(b) num |= 1;
            num <<= 1;
        }
        return num;
    }
}