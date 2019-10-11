package EducativeIo.Courses.GrokkingTheCodingInterview.Ch12_ModifiedBinarySearch.P5_SearchInASortedInfiniteArray.Java;

public class Solution {
    public static void main(String[] args) {
        ArrayReader reader =
                new ArrayReader(new int[] {4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30});
        System.out.println(search(reader, 16));
        System.out.println(search(reader, 11));
        reader = new ArrayReader(new int[] {1, 3, 8, 10, 15});
        System.out.println(search(reader, 15));
        System.out.println(search(reader, 200));
    }

    public static int search(ArrayReader reader, int key) {
    // TODO: Write your code here
    return -1;
  }
}
