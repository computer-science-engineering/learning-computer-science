package LeetCode.src.Problems.P601_P700.P605_CanPlaceFlowers.Java;

public class Solution {
    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,1};
        int n = 1;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 1;
        int result = 0;
        for(int i=0; i<flowerbed.length; i++) {
            if(flowerbed[i] == 0) {
                count++;
            } else {
                result += (count-1)/2;
                count = 0;
            }
        }
        if(count != 0) {
            result += count/2;
        }
        return result >= n;
    }
}