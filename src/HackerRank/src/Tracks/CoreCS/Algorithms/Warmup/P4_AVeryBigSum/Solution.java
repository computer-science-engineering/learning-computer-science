package HackerRank.src.Tracks.CoreCS.Algorithms.Warmup.P4_AVeryBigSum;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCount = scan.nextInt();
        scan.nextLine();
        String[] numbers = scan.nextLine().split(" ");

        long total = 0;
        for(int i=0; i<numCount; i++){
            total += Long.parseLong(numbers[i]);
        }
        System.out.println(total);
    }
}