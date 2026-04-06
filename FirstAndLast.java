public class FirstAndLast {


    int val;
    ListNode next;
    void ListNode(int val) { this.val = val; }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int first = findBound(nums, target, true);
        int last = findBound(nums, target, false);

        System.out.println("Target " + target + " is located from index " + first + " to " + last);
    }

    // Logic: A Binary Search that doesn't stop at the first match
    public static int findBound(int[] nums, int target, boolean isFirst) {
        int low = 0, high = nums.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                result = mid; // We found it, but let's see if there's another one...
                if (isFirst) {
                    high = mid - 1; // Look LEFT for an earlier one
                } else {
                    low = mid + 1;  // Look RIGHT for a later one
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}

