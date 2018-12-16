package LeetCode.src.Explore.Interview.GoogleInterview.InterviewProcess.LicenseKeyFormatting.Java;

public class Solution {
    public static void main(String[] args) {
        String S = "---";
        int K = 3;
        System.out.println(licenseKeyFormatting(S, K));
    }

    public static String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int subSectionCount = 0;
        for(int i=S.length()-1; i>=0; i--) {
            if (subSectionCount < K) {
                if (S.charAt(i) != '-') {                    
                    subSectionCount++;
                    sb.append(S.charAt(i));
                }
            } else {
                subSectionCount = 0; // reset
                if (S.charAt(i) != '-') {
                    sb.append("-");
                    sb.append(S.charAt(i));
                    subSectionCount++;
                } else {
                    sb.append(S.charAt(i));
                }
            }
        }

        String result = sb.reverse().toString();
        if (result.length() > 0 && result.charAt(0) == '-') {
            result = result.substring(1);
        }
        return result.toUpperCase();
    }
}