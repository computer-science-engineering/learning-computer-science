package HackerRank.src.Tutorials.ThirtyDaysOfCode.D25_RunningTimeAndComplexity;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> inputs = new ArrayList<>();
        int numberOfInputs = scan.nextInt();
        while(numberOfInputs-- > 0){
            int num = scan.nextInt();
            inputs.add(num);
        }

        for(int i=0; i<inputs.size(); i++){
            CheckIfPrime(inputs.get(i));
        }
        scan.close();
    }

    public static void CheckIfPrime(int num){
        if (num == 1){
            System.out.println("Not prime");
            return;
        }
        for (int i=2; i<=Math.sqrt(num); i++){
            if (num%i == 0){
                System.out.println("Not prime");
                return;
            }
        }
        System.out.println("Prime");
    }
}
