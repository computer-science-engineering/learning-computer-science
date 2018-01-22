package HackerRank.src.Tutorials.ThirtyDaysOfCode.D26_NestedLogic;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String actualReturnDate = sc.nextLine();
        String expectedReturnDate = sc.nextLine();
        String[] actualReturn = actualReturnDate.split(" ");
        String[] expectedReturn = expectedReturnDate.split(" ");
        int fine = 0;
        if(Integer.parseInt(actualReturn[2]) > Integer.parseInt(expectedReturn[2])){
            fine = 10000;
        }
        else if (Integer.parseInt(actualReturn[1]) > Integer.parseInt(expectedReturn[1])){
            if(Integer.parseInt(actualReturn[2]) == Integer.parseInt(expectedReturn[2])) {
                int numMonthsLate = Integer.parseInt(actualReturn[1]) - Integer.parseInt(expectedReturn[1]);
                fine = 500 * numMonthsLate;
            }
        }
        else if (Integer.parseInt(actualReturn[0]) > Integer.parseInt(expectedReturn[0])){
            if((Integer.parseInt(actualReturn[2]) == Integer.parseInt(expectedReturn[2])) &&
                    (Integer.parseInt(actualReturn[1]) == Integer.parseInt(expectedReturn[1]))) {
                int numDaysLate = Integer.parseInt(actualReturn[0]) - Integer.parseInt(expectedReturn[0]);
                fine = 15 * numDaysLate;
            }
        }

        System.out.println(fine);
        sc.close();
    }
}
