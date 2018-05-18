package InterviewBit.src.Courses.Programming.Level3_Strings.Problems.StringMath.MultiplyStrings.Java;

public class Solution {
    public static void main(String[] args) {
        System.out.println(multiply("12", "10"));
    }    

    public static String multiply(String A, String B) {
        String n1 = new StringBuilder(A).reverse().toString();
        String n2 = new StringBuilder(B).reverse().toString();
    
        int[] d = new int[A.length()+B.length()];
    
        // multiply each digit and sum at the corresponding positions
        for(int i=0; i<n1.length(); i++) {
            for(int j=0; j<n2.length(); j++) {
                d[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');
            }
        }
    
        StringBuilder sb = new StringBuilder();
    
        // calculate each digit
        for(int i=0; i<d.length; i++) {
            int mod = d[i]%10;
            int carry = d[i]/10;
            if(i+1<d.length) {
                d[i+1] += carry;
            }
            sb.insert(0, mod);
        }
    
        // remove front 0's
        while(sb.charAt(0) == '0' && sb.length()> 1) {
            sb.deleteCharAt(0);
        }
    
        return sb.toString();
    }
}