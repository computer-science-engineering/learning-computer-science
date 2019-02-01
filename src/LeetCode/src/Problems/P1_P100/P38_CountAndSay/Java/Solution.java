package LeetCode.src.Problems.P1_P100.P38_CountAndSay.Java;

public class Solution {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
        System.out.println(countAndSay_gfg(4));
    }

    public static String countAndSay(int n) {
        if(n <= 0) {
            return null;
        }
        String result = "1";
        int i = 1;
        
        while(i < n) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for(int j = 1; j < result.length(); j++) {
                if(result.charAt(j) == result.charAt(j-1)) {
                    count++;
                } else {
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

    public static String countAndSay_gfg(int n) {
        // Base cases 
        if (n == 1)     return "1"; 
        if (n == 2)     return "11"; 
    
        // Find nth term by generating  
        // all terms from 3 to n-1.  
        // Every term is generated  
        // using previous term 
        
        // Initialize previous term 
        String str = "11";  
        for (int i = 3; i <= n; i++) { 
            // In below for loop, previous  
            // character is processed in  
            // current iteration. That is 
            // why a dummy character is  
            // added to make sure that loop 
            // runs one extra iteration. 
            str += '$'; 
            int len = str.length(); 
    
            int cnt = 1; // Initialize count  
                        // of matching chars 
            String tmp = ""; // Initialize i'th  
                            // term in series 
            char []arr = str.toCharArray(); 
            
            // Process previous term 
            // to find the next term 
            for (int j = 1; j < len; j++) { 
                // If current character 
                // doesn't match 
                if (arr[j] != arr[j - 1]) { 
                    // Append count of  
                    // str[j-1] to temp 
                    tmp += cnt + 0; 
    
                    // Append str[j-1] 
                    tmp += arr[j - 1]; 
    
                    // Reset count 
                    cnt = 1; 
                } 
    
                // If matches, then increment  
                // count of matching characters 
                else cnt++; 
            } 
    
            // Update str 
            str = tmp; 
        } 
    
        return str; 
    }
}