package Firecode.src.Problems.Level1.ReverseAString.Java;

public class Solution {
    public static void main(String[] args) {
        String input = "";
        System.out.println(reverseString(input));
    }

    public static String reverseString(String str){
        String inputString = str;
        String outputString = null;  
        if (inputString == null || inputString == "") {
            return inputString;
        }      
        int length = inputString.length();
        StringBuilder sb = new StringBuilder();
        for(int i=length-1; i>=0; i--) {
            sb.append(inputString.charAt(i));
        }
        outputString = sb.toString();
        return outputString;
    }    
}