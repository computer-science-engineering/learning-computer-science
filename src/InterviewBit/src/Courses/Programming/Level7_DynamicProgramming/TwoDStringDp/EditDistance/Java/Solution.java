package InterviewBit.src.Courses.Programming.Level7_DynamicProgramming.TwoDStringDp.EditDistance.Java;

public class Solution {
    public static void main(String[] args) {
        String A = "Anshuman";
        String B = "Antihuman";
        System.out.println(minDistance(A, B));
    }
    
    public static int minDistance(String A, String B) {
        int m = A.length();
        int n = B.length();
        
        int[][] cost = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++) {
            cost[i][0] = i;
        }
        for(int i = 1; i <= n; i++) {
            cost[0][i] = i;
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(A.charAt(i) == B.charAt(j)) {
                    cost[i + 1][j + 1] = cost[i][j];
                }
                else {
                    int replace = cost[i][j];
                    int delete = cost[i][j + 1];
                    int insert = cost[i + 1][j];
                    cost[i + 1][j + 1] = Math.min(replace, Math.min(delete, insert)) + 1;
                }
            }
        }
        return cost[m][n];
    }
}