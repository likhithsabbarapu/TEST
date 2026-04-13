// The Challenge: Sort Colors
//
//Problem: You are given an array with n objects colored red, white, or blue. They are represented by the integers 0 (red), 1 (white), and 2 (blue). You must sort them in-place so that objects of the same color are adjacent, in the order red, white, and blue.
//
//    Example: [2, 0, 2, 1, 1, 0]
//
//    Goal: [0, 0, 1, 1, 2, 2]
//
//    The Rule: You cannot use the built-in Arrays.sort(). You have to do it manually in one go!
//For a Developer (The Three-Pointer Swap)
//
//This is an O(n) time complexity solution with O(1) space. We use three pointers: low, mid, and high.
//The Technical Strategy
//
//    Low: Tracks where the next 0 should go.
//
//    Mid: The "explorer" pointer that looks at every element.
//
//    High: Tracks where the next 2 should go.
//
//The Swap Logic:
//
//    If nums[mid] == 0: Swap with low, move both low and mid forward.
//
//    If nums[mid] == 1: Just move mid forward.
//
//    If nums[mid] == 2: Swap with high, move high backward (but don't move mid yet, because you need to check the new ball that was swapped in!).
import java.util.Arrays;

public class ColorSorter {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println("Sorted colors: " + Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Found a Red ball, move it to the low section
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // White ball is already in the right place (middle)
                mid++;
            } else {
                // Found a Blue ball, move it to the high section
                swap(nums, mid, high);
                high--;
                // Note: we don't increment mid here because the swapped 
                // value from 'high' could be a 0 or a 1!
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}