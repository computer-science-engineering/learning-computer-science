package HackerRank.src.Tutorials.ThirtyDaysOfCode.D16_Exceptions_StringToInteger.Java;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        try{
            System.out.println(Integer.parseInt(S));
        }
        catch(Exception ex){
            System.out.println("Bad String");
        }
        in.close();
    }
}
