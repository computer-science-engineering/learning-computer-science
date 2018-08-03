package LeetCode.src.Problems.P701_P800.P730_CountDifferentPalindromicSubsequences.Java;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Solution {
    static int div=1000000007;
    
    public static void main(String[] args) {
        String S = "bccb";
        System.out.println(countPalindromicSubsequences(S));
        System.out.println(countPalindromicSubsequences_opt(S));
    }

    public static int countPalindromicSubsequences(String S) {
        List<TreeSet<Integer>> characters = new ArrayList<TreeSet<Integer>>(26);
        int len = S.length();
        
        for (int i = 0; i < 26; i++) {
            characters.add(i, new TreeSet<Integer>());
        }
        
        for (int i = 0; i < len; ++i) {
            int c = S.charAt(i) - 'a';
            characters.get(c).add(i);
        }
        Integer[][] dp = new Integer[len+1][len+1];
        return memo(S, characters, dp, 0, len);
    }
    
    public static int memo(String S, List<TreeSet<Integer>> characters, Integer[][] dp, int start, int end){
        if (start >= end) {
            return 0;
        }

        if(dp[start][end] != null) {
            return dp[start][end];
        }
       
        long ans = 0;
        
        for(int i = 0; i < 26; i++) {
            Integer new_start = characters.get(i).ceiling(start);
            Integer new_end = characters.get(i).lower(end);
            if (new_start == null || new_start >= end) {
                continue;
            }
            ans++;
            if (new_start != new_end) {
                ans++;
            }
            ans+= memo(S, characters, dp, new_start+1, new_end);            
        }
        dp[start][end] = (int)(ans%div);
        return dp[start][end];
    }

    public static int countPalindromicSubsequences_opt(String S) {
        char[] cs = S.toCharArray();
        int n = cs.length;
        int[] cnts = new int[n];
        for(int i = 0; i < n; i++) {
            char c1 = cs[i] -= 'a';
            cnts[i] = 1;
            long sum = 0;
            int[] tmp = new int[4];
            for(int j = i - 1; j >= 0; j--) {
                char c2 = cs[j];
                int cnt = cnts[j];
                if(c1 == c2) {
                    cnts[j] = (int)((sum + 2) % div);
                }
                sum += cnt - tmp[c2];
                tmp[c2] = cnt;
            }
        }
        
        int[] nums = new int[4];
        for(int i = n - 1; i >= 0; i--) {
            nums[cs[i]] = cnts[i];
        }
        long sum = 0;
        for(int cnt : nums) {
            sum += cnt;
        }
        return (int)(sum % div);
    }
}