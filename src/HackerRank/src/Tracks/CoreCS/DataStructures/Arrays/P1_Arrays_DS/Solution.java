package HackerRank.src.Tracks.CoreCS.DataStructures.Arrays.P1_Arrays_DS;
//https://www.hackerrank.com/challenges/arrays-ds

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        scan.nextLine();
        int[] elements = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        for (int i=num-1; i>=0; i--){
            System.out.print(elements[i] + " ");
        }
        scan.close();
    }
}
