package InterviewBit.src.Courses.Programming.Level7_DynamicProgramming.DpTricky.BestTimeToBuyAndSellStocks3.Java;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int[] A = {1, 2, 1, 2};
        List<Integer> a = Arrays.stream(A).boxed().collect(Collectors.toList());
        System.out.println(maxProfit(A));
        System.out.println(maxProfit_Editorial(a));
    }
    
    public static int maxProfit(final int[] A) {
        int K = 2;
        if (K == 0 || A.length == 0) {
            return 0;
        }

        int T[][] = new int[K+1][A.length];

        for (int i = 1; i < T.length; i++) {
            int maxDiff = -A[0];
            for (int j = 1; j < T[0].length; j++) {
                T[i][j] = Math.max(T[i][j-1], A[j] + maxDiff);
                maxDiff = Math.max(maxDiff, T[i-1][j] - A[j]);
            }
        }

        printActualSolution(T, A);
        return T[K][A.length-1];
    }

    private static void printActualSolution(int T[][], int prices[]) {
        int i = T.length - 1;
        int j = T[0].length - 1;

        Deque<Integer> stack = new LinkedList<>();
        while(true) {
            if(i == 0 || j == 0) {
                break;
            }
            if (T[i][j] == T[i][j-1]) {
                j = j - 1;
            } else {
                stack.addFirst(j);
                int maxDiff = T[i][j] - prices[j];
                for (int k = j-1; k >= 0; k--) {
                    if (T[i-1][k] - prices[k] == maxDiff) {
                        i = i - 1;
                        j = k;
                        stack.addFirst(j);
                        break;
                    }
                }
            }
        }

        while(!stack.isEmpty()) {
            System.out.println("Buy at price " + prices[stack.pollFirst()]);
            System.out.println("Sell at price " + prices[stack.pollFirst()]);
        }

    }

    public static int maxProfit_Editorial(final List<Integer> prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far. 
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }
}