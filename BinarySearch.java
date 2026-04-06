public class BinarySearch {

    // ... keep your other code ...

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 2;

        int result = searchInsert(nums, target);
        System.out.println("The target " + target + " should be at index: " + result);
    }

    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid; // Found it!
            } else if (nums[mid] < target) {
                low = mid + 1; // Look in the right half
            } else {
                high = mid - 1; // Look in the left half
            }
        }

        // If we don't find it, 'low' is exactly where the number
        // would have been inserted!
        return low;
    }
}
