package HackerRank.src.Tracks.Tutorials.ThirtyDaysOfCode.D27_Testing.Java;

import java.util.concurrent.ThreadLocalRandom;

public class Solution {

    public static void main(String[] args) {
        //System.out.println("Hello World");
        int t = GetRandomNumber(1,5);
        System.out.println(t);
        for(int i=0;i<t;i++){

            int n = GetRandomNumber(1,200);
            System.out.print(n);
            int k = GetRandomNumber(1,n);
            System.out.println(" "+k);

            int[] arrival = new int[n];

            for(int j=0;j<n;j++){
                arrival[j] = GetRandomNumber(-10^3,10^3);
                System.out.print(arrival[j]+" ");
            }
            System.out.println("");
        }
        //System.out.println("");
    }

    public static int GetRandomNumber(int min, int max){
        if (min > max){
            throw new IllegalArgumentException("min is large than max");
        }
        //Random rand = new Random();
        //return rand.nextInt((max - min) + 1) + min;
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
