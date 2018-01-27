package HackerRank.src.Tutorials.ThirtyDaysOfCode.D10_BinaryNumbers.Java;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        String binNum = ConvertToBinary(num);
        System.out.println(NumOfConsecutiveOnes(binNum));
        scan.close();
    }
    
    public static String ConvertToBinary(int n){
        List<String> res = new ArrayList<>();
        while(n > 0){
            int rem = n%2;
            n = n/2;
            res.add(String.valueOf(rem));
        }
        String resString = "";
        for (int i=res.size()-1; i>=0; i--){
            resString = resString + res.get(i);
        }
        return resString;
    }
    
    public static int NumOfConsecutiveOnes(String binNum){
        char[] arr = binNum.toCharArray();
        int res = 0, prevRes = 0;
        for (int i = 0; i < arr.length; i++) {
            if (Character.getNumericValue(arr[i]) == 1) {
                res++;
            }
            else{
                if (res > prevRes){
                    prevRes = res;
                }
                res = 0;
            }
        }
        // handle case when last occurrence is a 1 in which case we won't enter the else loop above. Eg: 95789
        if (res > prevRes){
            prevRes = res;
        }
        return prevRes;
    }
}
