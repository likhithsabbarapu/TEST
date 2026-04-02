import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        // 1. Create an instance of our solution
        solution solver = new solution();

        // 2. Define test data
        int[] testNums = {2, 7, 11, 15};
        int testTarget = 9;

        // 3. Run the method and catch the result
        int[] result = solver.twoSum(testNums, testTarget);

        // 4. Print the result
        System.out.println("Indices: " + Arrays.toString(result));
    }
}

class solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> prevMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int complement = target - currentNum;

            if (prevMap.containsKey(complement)) {
                return new int[] { prevMap.get(complement), i };
            }
            prevMap.put(currentNum, i);
        }
        return new int[] {}; // No solution found
    }
}