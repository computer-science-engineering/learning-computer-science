package HackerRank.src.Tracks.CoreCS.Algorithms.Warmup.Staircase.Java;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        for (int i=1; i<=size; i++){
            int spaces = size-i;
            while(spaces-- > 0) {
                System.out.print(" ");
            }
            int hashes = i-1;
            while(hashes-- > 0){
                System.out.print("#");
            }
            System.out.println("#");
        }
        scan.close();
    }
}
