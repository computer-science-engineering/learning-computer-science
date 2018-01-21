package Courses.Programming.Level2_Math.Problems.BaseConversion.ExcelColumnTitle;

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertToTitle(260));
    }
    
    public static String convertToTitle(int A) {
        if(A <= 0) {
            throw new IllegalArgumentException("Input is not valid!");
        }
        StringBuilder sb = new StringBuilder();        
        while(A > 0) {
            A--;
            int remainder  = A % 26;
            char ch = (char) (remainder + 'A');
            A /= 26;
            sb.append(ch);
        }    
        sb.reverse();
        return sb.toString();
    }
}