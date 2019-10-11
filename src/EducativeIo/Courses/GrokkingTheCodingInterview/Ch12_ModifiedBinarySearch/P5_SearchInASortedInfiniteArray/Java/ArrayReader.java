package EducativeIo.Courses.GrokkingTheCodingInterview.Ch12_ModifiedBinarySearch.P5_SearchInASortedInfiniteArray.Java;

class ArrayReader {
    int[] arr;

    ArrayReader(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        if (index >= arr.length)
            return Integer.MAX_VALUE;
        return arr[index];
    }
}
