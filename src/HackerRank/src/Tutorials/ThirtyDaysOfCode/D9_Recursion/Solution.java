package HackerRank.src.Tutorials.ThirtyDaysOfCode.D9_Recursion;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        System.out.println(Factorial(num));
        scan.close();
    }
    
    public static int Factorial(int n){
        if (n <= 1){
            return 1;
        }
        else{
            return (n * Factorial(n-1));
        }
    }
}
