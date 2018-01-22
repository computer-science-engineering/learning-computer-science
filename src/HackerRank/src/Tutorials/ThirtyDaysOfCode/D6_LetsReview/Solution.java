package HackerRank.src.Tutorials.ThirtyDaysOfCode.D6_LetsReview;

import java.util.*;

public class Solution {
    private char[] _str;
    private String _evenStr = "";
    private String _oddStr = "";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOfStrings = scan.nextInt();
        scan.nextLine();
        for (int i=0; i<numOfStrings; i++){
            String str = scan.nextLine();
            Solution sol = new Solution(str);
            sol.SeparateChars();
            System.out.println(sol.GetEvenCharsString() + " " + sol.GetOddCharsString());
        }
        
        scan.close();
    }

    public Solution(String str){
        _str = str.toCharArray();
    }

    public void SeparateChars() {
        for (int i = 0; i < _str.length; i++) {
            if (i%2 == 1) { //odd
                _oddStr = _oddStr + _str[i];
            }
            else{ //even
                _evenStr = _evenStr + _str[i];
            }
        }
    }

    public String GetEvenCharsString() { return _evenStr; }

    public String GetOddCharsString() { return _oddStr; }
}
