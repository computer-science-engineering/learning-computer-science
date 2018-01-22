package HackerRank.src.Contests.RookieRank2.HackerRankInAString.Java;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            String result = hackerrankInString(s);
            System.out.println(result);
        }
        in.close();
    }

    public static String hackerrankInString(String s) {        
        boolean failed = false;
        char[] hr = {'h','a','c','k','e','r','r','a','n','k'};
        for (char c: hr) {
            int idx = s.indexOf(c);
            if (idx == -1) {
                failed = true;
                break;
            }
            s = s.substring(idx+1, s.length());
        }

        if (failed) {
            return "NO";
        }
        else {
            return "YES";
        }
    }
}
