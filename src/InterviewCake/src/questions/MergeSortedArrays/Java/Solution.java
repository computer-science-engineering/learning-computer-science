package InterviewCake.src.Questions.MergeSortedArrays.Java;

public class Solution {
    public static void main(String[] args) {
        int[] myArray     = new int[]{3, 4, 6, 10, 11, 15};
        int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};
        int[] result = mergeSortedArrays(myArray, alicesArray);
        for(int i=0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] mergeSortedArrays(int[] myArray, int[] alicesArray) {
        int[] mergedArray = new int[myArray.length + alicesArray.length];
        int i=0, j=0, k=0;
        while(i<myArray.length && j<alicesArray.length) {
            if (myArray[i] < alicesArray[j]) {
                mergedArray[k++] = myArray[i++];                
            } else {
                mergedArray[k++] = alicesArray[j++];
            }            
        }

        while (i < myArray.length) {
            mergedArray[k++] = myArray[i++];
        }

        while (j < alicesArray.length) {
            mergedArray[k++] = alicesArray[j++];
        }

        return mergedArray;
    }    
}