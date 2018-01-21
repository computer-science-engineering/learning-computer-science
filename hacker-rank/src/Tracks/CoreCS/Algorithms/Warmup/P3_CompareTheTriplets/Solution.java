package Tracks.CoreCS.Algorithms.Warmup.P3_CompareTheTriplets;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] aliceStr = scan.nextLine().split(" ");
        String[] bobStr = scan.nextLine().split(" ");

        int aliceScore = 0;
        int bobScore = 0;
        for(int i=0; i<3; i++){
            if (Integer.parseInt(aliceStr[i]) > Integer.parseInt(bobStr[i])){
                aliceScore++;
            }
            else if (Integer.parseInt(aliceStr[i]) < Integer.parseInt(bobStr[i])){
                bobScore++;
            }
        }
        System.out.println(aliceScore + " " + bobScore);
    }
}
