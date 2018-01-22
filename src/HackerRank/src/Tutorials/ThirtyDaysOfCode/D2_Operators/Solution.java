package HackerRank.src.Tutorials.ThirtyDaysOfCode.D2_Operators;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double mealCost = scan.nextDouble(); // original meal price
        int tipPercent = scan.nextInt(); // tip percentage
        int taxPercent = scan.nextInt(); // tax percentage
        scan.close();
      
        // Write your calculation code here.
        double tipCost = mealCost * ((double)tipPercent/(double)100);
        //System.out.println(tipCost);
        double taxCost = mealCost * ((double)taxPercent/(double)100);
        //System.out.println(taxCost);
      
        // cast the result of the rounding operation to an int and save it as totalCost 
        int totalCost = (int) Math.round(mealCost + tipCost + taxCost);
      
        // Print your result
        System.out.println("The total meal cost is " + totalCost + " dollars.");
    }
}
