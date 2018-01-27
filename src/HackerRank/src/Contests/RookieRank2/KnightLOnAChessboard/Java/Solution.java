package HackerRank.src.Contests.RookieRank2.KnightLOnAChessboard.Java;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 5;//in.nextInt();
        // your code goes here
        //Map<int[], Integer> map = new HashMap<int[], Integer>();

        //int[] position = new int[]{0,0};
        for (int i=1; i<n; i++){
            for (int j=1; j<n; j++){
                //int[] nextPos = Solution.GetNextPosition(position, new int[]{i,j});
            }
        }
        in.close();
    }

    public static int[] GetNextPosition(int[] currentPos, int[] increment){
        int[] res = new int[2];
        res[0] = currentPos[0] + increment[0];
        res[1] = currentPos[1] + increment[1];
        return res;
    }
}