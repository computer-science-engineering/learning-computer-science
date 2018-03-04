package InterviewBit.src.Courses.Programming.Level2_Math.Problems.ArrayDp.NumbersOfLengthNAndValuesLessThanK.Java;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(3, 0, 1, 5));
        int B = 1;
        int C = 2;
        int result = solve(A, B, C);
        System.out.println(result);
    }

    public static int solve(ArrayList<Integer> A, int B, int C) {
        char[] ca = Integer.toString(C).toCharArray();

        if (A.size() == 0 || B > ca.length) {
            return 0;
        }

        if (B < ca.length) {
            if (A.get(0) == 0 && B > 1)
                return (A.size() - 1) * (int)Math.pow(A.size(), B - 1);
            else 
                return (int)Math.pow(A.size(), B);
        }

        int cntLessOrEq[] = new int[10];
        for (int i = 0; i < A.size(); i++) {
            cntLessOrEq[A.get(i)] = 1;
        }

        for (int i = 1; i < cntLessOrEq.length; i++) {
            cntLessOrEq[i] = cntLessOrEq[i - 1] + cntLessOrEq[i];
        }

        int dp = 0;
        int hasEqDigitsBefore = 1;
        for (int i = 0; i < ca.length; i++) {
            int d = ca[i] - 48;

            int hasEq = (d > 0) ? cntLessOrEq[d] - cntLessOrEq[d - 1] : cntLessOrEq[d];
            
            int cntLess = (d > 0) ? cntLessOrEq[d - 1] : 0;
            if (i == 0 && B > 1 && cntLessOrEq[0] == 1) {
                cntLess--;
            }

            dp = dp * A.size() + hasEqDigitsBefore * cntLess;
            hasEqDigitsBefore *= hasEq;
        }

        return dp;
    }

    public int solve_Editorial(ArrayList<Integer> A, int B, int C) {
        String str=Integer.toString(C);
        int cl=str.length();
        int size=A.size();
        int d=size,d2;
        if(B>cl || C==0 || size==0)
            return 0;
        int zeros=A.lastIndexOf(0)-A.indexOf(0)+1;
        boolean zero=A.contains(0);
        int ans=0;
        if(B<cl){
            if(zero && B!=1)
                ans += size-1;
            else
                ans=size;
            for(int i=1;i<B;i++)
                ans *= size;
            return ans;
        }
        
        int dp[]=new int[B+1];
        int lower[]=new int[11];
        
        if(B==cl){
            
            for(int i = 0; i <= B; i++)
              dp[i] = 0;
            for(int i = 0; i <= 10; i++)
              lower[i] = 0;
            for(int i = 0; i < d; i++)
              lower[A.get(i) + 1] = 1;

            for(int i = 1; i <= 10; i++)
              lower[i] = lower[i-1] + lower[i]; 

                boolean flag = true;
                dp[0] = 0;
                for(int i = 1; i <= B; i++) {
                    int digit=str.charAt(i-1)-'0';
                  d2 = lower[digit];
                  dp[i] = dp[i-1] * d;
    
                  // For first index we can't use 0
                if(i == 1 &&  A.get(0) == 0 && B != 1)
                     d2 = d2 - 1;
    
                 //Whether (i-1) digit of generated number can be equal to (i - 1) digit of C.
                 if(flag)
                     dp[i] += d2;
             //Is digit[i - 1] present in A ?
                flag = flag & (lower[digit + 1] == lower[digit] + 1);
            }
            return dp[B];          
        
        }
        return 0;        
    }
}