package LeetCode.src.Problems.P1_P100.P10_RegularExpressionMatching.Java;

class Solution {     
    
    public static void main(String[] args) {
        String text = "";
        String pattern = "a*";
        System.out.println(isMatch(text, pattern));
    }

    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];

        // empty pattern can match with empty string
        dp[0][0] = true;
        
        // Only '*' can match with empty string
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
  
    /*public static boolean isMatch_gfg(String text, String pattern) {
        int x = text.length();
        int y = pattern.length();
        
        // easiest case
        if (x == 0) {
        return y == 0;
        }
        
        boolean[][] track = new boolean[x+1][y+1];
        
        track[0][0] = true;
        
        // handle "*" during initialization
        for(int j=1; j<=y; j++) {
            if (pattern.charAt(j-1) == '*') {
                track[0][j] = track[0][j-1];
            }
        }    

        // populate matrix
        for(int i=1; i<=x; i++) {
            for(int j=1; j<=y; j++) {
                // handle "*"
                if (pattern.charAt(j-1) == '*') {
                track[i][j] = track[i][j-1] || track[i-1][j] || track[i][j-2];
                } else if (pattern.charAt(j-1) == '.' || text.charAt(i-1) == pattern.charAt(j-1)) {
                track[i][j] = track[i-1][j-1];
                } else  {// no match
                track[i][j] = false;
                }
            }
        }
        
        return track[x][y];    
    }*/
}