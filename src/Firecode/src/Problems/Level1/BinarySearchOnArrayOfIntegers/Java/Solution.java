package Firecode.src.Problems.Level1.BinarySearchOnArrayOfIntegers.Java;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {2,5,7,8,9};
        System.out.println(binarySearch(arr, 9));
    }

    public static Boolean binarySearch(int[] arr, int n) {
        int start = 0;
        int end = arr.length-1;
        while(start<=end) {
            int mid = start + ((end-start)/2);
            if (arr[mid] == n) {
                return true;
            }
            else if (n < arr[mid]) {
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        return false;
    }    
}