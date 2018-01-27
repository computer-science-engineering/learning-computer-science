package HackerRank.src.Tracks.CoreCS.Algorithms.Warmup.CircularArrayRotation.Java;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //int numOfElements = scan.nextInt();
        int numOfRotations = scan.nextInt();
        int numOfQueries = scan.nextInt();
        scan.nextLine();
        int[] elements = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        //int arrayLength = elements.length;
        //elements = rightRotate2(elements, numOfRotations, numOfElements);

        while(numOfQueries-- > 0){
            int pos = Integer.parseInt(scan.nextLine());
            System.out.println(GetItem(elements, numOfRotations, pos));
        }
        scan.close();
    }

    public static int GetItem(int[] a, int k, int m) {
        int n = a.length;
        return a[(((m - k) % n) + n) % n];
    }

    /*Naive method
    public static int[] rightRotate1(int[] arr, int n, int size)
    {
        int i;
        for (i = 0; i < n; i++) {
            arr = rightRotatebyOne(arr, size);
        }
        return arr;
    }

    public static int[] rightRotatebyOne(int[] arr, int size)
    {
        int i, temp;
        temp = arr[size-1];
        for (i = size-1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
        return arr;
    }
    */

    /*Improved method
    public static int[] rightRotate2(int[] arr, int n, int size){
        int rotationIndex = gcd(n, size);
        for (int i = 0; i < n; i++) {
            arr = rightRotatebyIndex(arr, size, rotationIndex);
        }
        return arr;
    }

    //Bad code. Doesn't work
    public static int[] rightRotatebyIndex(int[] arr, int size, int rotationIndex)
    {
        int i, temp;
        temp = arr[size-1];
        for (i = size-1; i > 0; i=i-rotationIndex) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
        return arr;
    }

    public static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
    */
}
