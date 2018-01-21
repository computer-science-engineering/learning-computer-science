package Courses.Programming.Level2_Math.Problems.Adhoc.PrimeSum;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> result = primeSum(10);
        result.forEach((x) -> {
            System.out.print(x + " ");
        });
    }
    
    public static ArrayList<Integer> primeSum(int A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(A < 2) {
            return result;
        }
        
        int first = 2;
        int second = A - first; 
        while(first <= second) {
            second = A - first;
            //System.out.printf("isPrime(%d) : %s \n ", second, isPrime(second)); 
            //System.out.printf("isPrime(%d) : %s \n ", first, isPrime(first)); 
            if(isPrime(second) == true && isPrime(first)) {
                result.add(first);
                result.add(second);
                return result;
            }
            first++;
        }
        
        return result;
    }

    public static boolean isPrime(int n){        
        if(n == 2) {
            return true;
        }
        if(n%2 == 0) {
            return false;
        }
        for(int i=2; i<n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}