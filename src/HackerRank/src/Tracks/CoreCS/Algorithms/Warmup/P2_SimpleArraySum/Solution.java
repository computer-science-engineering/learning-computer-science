package HackerRank.src.Tracks.CoreCS.Algorithms.Warmup.P2_SimpleArraySum;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int res = 0;
        while (num-- > 0){
            res = res + scan.nextInt();
        }
        System.out.println(res); 
        scan.close();
    }
}