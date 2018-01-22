package HackerRank.src.Tracks.CoreCS.Algorithms.Warmup.P6_PlusMinus;
//https://www.hackerrank.com/challenges/plus-minus

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCount = scan.nextInt();
        scan.nextLine();
        int numOfNegatives = 0;
        int numOfZeroes = 0;
        int numOfPositives = 0;
        for(int i=0; i<numCount; i++){
            int num = scan.nextInt();
            if (num < 0){
                numOfNegatives++;
            }
            else if (num ==0){
                numOfZeroes++;
            }
            else{
                numOfPositives++;
            }
        }
        scan.close();
        DecimalFormat format = new DecimalFormat("#0.000000");
        System.out.println(format.format((double)numOfPositives/numCount));
        System.out.println(format.format((double)numOfNegatives/numCount));
        System.out.println(format.format((double)numOfZeroes/numCount));
    }
}
