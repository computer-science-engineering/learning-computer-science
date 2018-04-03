package InterviewBit.src.Courses.Programming.Level7_DynamicProgramming.WaysToDecode.Java;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(numDecodings("123"));
    }

    public static int numDecodings(String A) {
        if(A == null) {
            return 0;
        }
        int n = A.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = A.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(A.substring(i-1, i));
            int second = Integer.valueOf(A.substring(i-2, i));
            if(first >= 1 && first <= 9) {
               dp[i] += dp[i-1];  
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }    

    // Editorial

    private int [] dp;
    private int N;
    private String A;
    
	public int numDecodings_Editorial(String A) {	    
	    if (A == null) {
            return 0;
        }
	    
	    N = A.length();
	        
	    dp = new int[N];
	    Arrays.fill(dp, -1);
	    this.A = A;
	    
	    return rec(N - 1);
	}
	
	
	private int rec(int index) {
	        
	    if (index < 0)
	        return 1;
	        
	    if (dp[index] != -1)
	        return dp[index];
	    
	    int ways = 0;
	    
	    if (A.charAt(index) > '0') {
        	ways = rec(index - 1);
	    }
    	    
	    if (isValidTwoDigits(index)) {
	        ways += rec(index - 2);
	    }
	    
	    return dp[index] = ways;
	}
	
	private boolean isValidTwoDigits(int index) {
	    if (index > 0 && (A.charAt(index - 1) == '1' || A.charAt(index - 1) == '2' && A.charAt(index) < '7')) {
            return true;
        }
	        
	    return false;
	}
}