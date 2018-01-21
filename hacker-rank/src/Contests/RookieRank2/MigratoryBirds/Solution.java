package Contests.RookieRank2.MigratoryBirds;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static Map<Integer , Integer> birds = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] types = new int[n];
        for(int types_i=0; types_i < n; types_i++){
            types[types_i] = in.nextInt();
        }
        for (int i=0; i<n; i++){
            Solution.TrackBird(types[i]);
        }
        System.out.println(Solution.GetMax());
    }

    public static void TrackBird(int i){
        if (birds.containsKey(i)){
            int current = birds.get(i);
            birds.put(i, ++current);
        }
        else{
            birds.put(i, 1);
        }
    }

    public static int GetMax(){
        int maxValue = 0;
        int maxKey = 0;
        for (Map.Entry<Integer, Integer> entry: birds.entrySet()){
            if(entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
            else if(entry.getValue() == maxValue){
                if (entry.getKey() < maxKey){
                    maxKey = entry.getKey();
                }
            }
        }
        return maxKey;
    }
}