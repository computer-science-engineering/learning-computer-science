package Tracks.CoreCS.Algorithms.Warmup.P5_DiagonalDifference;
//https://www.hackerrank.com/challenges/diagonal-difference

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        int diag1sum = 0;
        int diag2sum = 0;
        //int[][] matrix = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int temp = scan.nextInt();
                if (i==j){
                    diag1sum += temp;
                }
                if (i == (n - j - 1)) {
                    diag2sum += temp;
                }
            }
            if (scan.hasNext()){
                scan.nextLine();
            }
        }
        System.out.println(Math.abs(diag1sum - diag2sum));
        scan.close();
    }
}
