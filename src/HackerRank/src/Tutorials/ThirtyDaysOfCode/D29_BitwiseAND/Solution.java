package HackerRank.src.Tutorials.ThirtyDaysOfCode.D29_BitwiseAND;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOfCases = scan.nextInt();
        while(numOfCases-- > 0){
            int s = scan.nextInt();
            int k = scan.nextInt();
            CalculateBitwiseAND(s, k);
        }
        scan.close();
    }

    public static void CalculateBitwiseAND(int s, int k){
        int res = 0;
        for (int i=1; i<=s; i++){
            for (int j=i+1; j<=s; j++){
                int temp = i & j;
                if (temp < k){
                    if (temp > res){
                        res = temp;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
