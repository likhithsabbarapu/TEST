///3Sum
///
/// Concept: Sorting + Two Pointers.
/// The Challenge: Find all unique triplets in an array that sum up to zero.
///
///     Example: [-1,0,1,2,-1,-4] → Output: [[-1,-1,2], [-1,0,1]].
///
/// The Logic:
/// This builds directly on your "Two Sum" knowledge but adds a layer:
///
///     Sort the array first.
///
///     Iterate through the array with a fixed pointer i.
///
///     For each i, treat the rest of the array like a Two Sum problem using two pointers (left and right).
///
///     The Logic Move: To avoid duplicates, skip the same number if you've already processed it.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {


    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();

        for(int i=0;i<nums.length-2;i++) {
            if(i>0 && nums[i]==nums[i-1]) continue; // Skip duplicates for i

            int left=i+1;
            int right=nums.length-1;

            while(left<right) {
                int sum=nums[i]+nums[left]+nums[right];

                if(sum==0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // Skip duplicates for left and right
                    while(left<right && nums[left]==nums[left-1]) left++;
                    while(left<right && nums[right]==nums[right+1]) right--;
                } else if(sum<0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
