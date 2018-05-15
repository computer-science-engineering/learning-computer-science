package InterviewBit.src.Courses.Programming.Level3_Strings.Problems.StringSimulation.CountAndSay.Java;

public class Solution {
    public static void main(String[] args) {
        System.out.println(countAndSay(60));
    }
    
    public static String countAndSay(int A) {
        if(A <= 0) {
            return null;
        }
        String result = "1";
        int i = 1;
        
        while(i < A) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for(int j = 1; j < result.length(); j++) {
                if(result.charAt(j) == result.charAt(j-1))
                    count++;
                else {
                    sb.append(count);
                    sb.append(result.charAt(j-1));
                    count = 1;
                }                    
            }
            sb.append(count);
            sb.append(result.charAt(result.length() - 1));
            result = sb.toString();
            i++;
        }
        return result;
    }
}