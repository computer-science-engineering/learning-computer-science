package HackerRank.src.Tutorials.ThirtyDaysOfCode.D1_DataTypes.Java;

import java.util.*;

public class Solution {
	
    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";
		
        Scanner scan = new Scanner(System.in);
        
        /* Declare second integer, double, and String variables. */
        int j = 0;
        double e = 0;
        String r = "";

        /* Read and save an integer, double, and String to your variables.*/        
        
        j = scan.nextInt();
        //System.out.println(j);
        scan.nextLine();
        e = scan.nextDouble();
        //System.out.println(e);
        scan.nextLine();
        r = scan.nextLine();
        //System.out.println(r); 

        // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.
        
        /* Print the sum of both integer variables on a new line. */
        System.out.println(i+j);

        /* Print the sum of the double variables on a new line. */
        System.out.println(d+e);
		
        /* Concatenate and print the String variables on a new line; 
        	the 's' variable above should be printed first. */
        System.out.println(s+r);
        
        scan.close();
    }
}
