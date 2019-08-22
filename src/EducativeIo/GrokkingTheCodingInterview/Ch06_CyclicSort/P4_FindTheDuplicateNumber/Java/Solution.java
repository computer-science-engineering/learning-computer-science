package EducativeIo.GrokkingTheCodingInterview.Ch06_CyclicSort.P4_FindTheDuplicateNumber.Java;

public class Solution {
    public static void main(String[] args) {
        System.out.println(findNumber(new int[] {1, 4, 4, 3, 2}));
        System.out.println(findNumber(new int[] {2, 1, 3, 3, 5, 4}));
        System.out.println(findNumber(new int[] {2, 4, 1, 4, 4}));
    }

    public static int findNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                if (nums[i] != nums[nums[i] - 1]) {
                    swap(nums, i, nums[i] - 1);
                } else { // we have found the duplicate
                    return nums[i];
                }
            } else {
                i++;
            }
        }

        return -1;
    }

    // O(1) space without modifying the input array
    public static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // find cycle length
        int current = nums[slow];
        int cycleLength = 0;
        do {
            current = nums[current];
            cycleLength++;
        } while (current != nums[slow]);

        return findStart(nums, cycleLength);
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int findStart(int[] arr, int cycleLength) {
        int pointer1 = arr[0], pointer2 = arr[0];
        // move pointer2 ahead 'cycleLength' steps
        while (cycleLength > 0) {
            pointer2 = arr[pointer2];
            cycleLength--;
        }

        // increment both pointers until they meet at the start of the cycle
        while (pointer1 != pointer2) {
            pointer1 = arr[pointer1];
            pointer2 = arr[pointer2];
        }

        return pointer1;
    }

}
