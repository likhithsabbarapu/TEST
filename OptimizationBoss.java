//high-level application: Binary Search, Sliding Windows, and Prefix Sums.
//The Challenge: The "Efficient Range" Optimizer
//
//Problem: Given an array of positive integers nums and a positive integer target, find the minimal length of a contiguous subarray of which the sum is greater than or equal to the target. If there is no such subarray, return 0.
//
//    Example: target = 7, nums = [2, 3, 1, 2, 4, 3]
//
//    Output: 2 (The subarray [4, 3] is the shortest one that sums to 7).
//
//The 3-Layer Logic
//1. Prefix Sums (The Foundation)
//
//To calculate the sum of any range quickly, we pre-calculate a "Running Total."
//
//    PrefixSum[i] = the sum of all numbers from the start up to index i.
//
//    To get the sum of nums[2...5], you just do PrefixSum[5] - PrefixSum[1]. This is O(1) speed!
//
//2. Sliding Window (The Moderate Layer)
//
//We use two pointers (left and right) to create a "window." We expand the right pointer to add numbers until the sum ≥ target. Then, we shrink the left pointer to see if we can maintain the sum with a smaller window.
//3. Binary Search (The "Boss" Layer)
//
//To make this truly complex, we can use Binary Search to search for the length of the window. We ask: "Is it possible to find a sum ≥ target using a window of size K?" If yes, we try a smaller K. If no, we need a larger K.


import java.util.*;

public class OptimizationBoss {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;

        int result = minSubArrayLen(target, nums);
        System.out.println("The smallest window size to reach " + target + " is: " + result);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int minLength = Integer.MAX_VALUE;

        // --- COMPLEX LOGIC: SLIDING WINDOW PATTERN ---
        int left = 0;
        int currentSum = 0;

        for (int right = 0; right < n; right++) {
            currentSum += nums[right];

            // While the current window meets the target, try to shrink it
            while (currentSum >= target) {
                // Update our global minimum length
                minLength = Math.min(minLength, right - left + 1);

                // Shrink the window from the left
                currentSum -= nums[left];
                left++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    // --- ADDING A SECOND METHOD FOR THE PREFIX SUM + BINARY SEARCH APPROACH ---
    public static int minSubArrayLenBinary(int target, int[] nums) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) sums[i] = sums[i - 1] + nums[i - 1];

        int minLen = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int toFind = target + sums[i - 1];
            int bound = Arrays.binarySearch(sums, toFind);
            if (bound < 0) bound = -bound - 1;
            if (bound <= n) {
                minLen = Math.min(minLen, bound - (i - 1));
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}