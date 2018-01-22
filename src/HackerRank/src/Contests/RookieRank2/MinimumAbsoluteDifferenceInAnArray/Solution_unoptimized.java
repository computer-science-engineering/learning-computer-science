package HackerRank.src.Contests.RookieRank2.MinimumAbsoluteDifferenceInAnArray;

import java.util.*;

public class Solution_unoptimized {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int minDiff = -10;
        for(int i=0; i<n; i++) {
            for (int j = i+1; j < n; j++) {
                int diff = Math.abs(a[i] - a[j]);
                if (minDiff == -10){
                    minDiff = diff;
                }
                if (diff < minDiff){
                    minDiff = diff;
                }
            }
        }
        System.out.println(minDiff);
        in.close();
    }
}
