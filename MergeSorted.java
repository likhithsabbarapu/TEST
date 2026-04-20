// The Challenge: Merge Sorted Array
//
//Problem: You are given two integer arrays, nums1 and nums2, each sorted in non-decreasing order. You are also given a pointer to the "actual" numbers in nums1 (since it has extra empty space at the end). Your goal is to merge nums2 into nums1 so that the final result is one single sorted array.
//
//    Input: nums1 = [1, 2, 3, 0, 0, 0], nums2 = [2, 5, 6]
//
//    Goal: nums1 becomes [1, 2, 2, 3, 5, 6]
//
//    Constraint: You must do this in-place (don't create a third array).
// For a Developer (The Three-Pointer Strategy)
//
//The "Aha!" moment here is realizing that by filling nums1 from the back, we avoid the O(n2) complexity of shifting elements. We use three pointers: p1 (end of data in nums1), p2 (end of nums2), and p (the absolute end of nums1).
//The Technical Strategy
//
//    Pointers: * i points to the last actual element in nums1.
//
//        j points to the last element in nums2.
//
//        k points to the very last index of the nums1 array.
//
//    Compare: Compare nums1[i] and nums2[j].
//
//    Place: Put the larger value at nums1[k] and move that pointer and k backward.
//
//    Cleanup: If nums2 still has numbers left after nums1 is exhausted, copy them over.
import java.util.Arrays;

public class MergeSorted {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0}; // Has space for 3 more
        int m = 3; // Actual numbers in nums1
        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);
        System.out.println("Merged Array: " + Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointer for the end of nums1's data
        int i = m - 1;
        // Pointer for the end of nums2
        int j = n - 1;
        // Pointer for the absolute end of nums1's total capacity
        int k = m + n - 1;

        // While there are elements in both arrays
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If nums2 still has items (nums1 finished first)
        // We don't need to check nums1 leftovers because they are already in place
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}