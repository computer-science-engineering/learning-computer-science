package HackerRank.src.Tutorials.ThirtyDaysOfCode.D5_Loops;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i=1; i<=10; i++){
            System.out.println(n + " x " + i + " = " + n*i);
        }
        in.close();
    }
}
