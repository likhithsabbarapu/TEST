// Imagine you have a big bucket of toy train cars. Each car has a number on it, like 100, 4, 200, 1, 3, 2.
//Your goal is to find the longest train you can build where the numbers go in order (1, 2, 3, 4...).
//The Simple Way (Slow)
//
//You could line them all up from smallest to biggest (Sorting). But if you have a billion cars, lining them up takes a very long time!
//The Smart Way (Fast)
//
//    Dump all the cars into a "Magic Box" (The HashSet).
//
//    Pick a car, say 4.
//
//    Ask the box: "Is there a 3?" If yes, then 4 isn't the start of the train. Ignore it for now!
//
//    Pick car 1. Ask the box: "Is there a 0?" The box says No.
//
//    AHA! Since there is no 0, 1 must be the start of a train.
//
//    Now ask the box: "Is there a 2? A 3? A 4?" You keep counting until the box says "No more."
//
//Part 2: For a Developer (O(n) Intelligent Hashing)
//
//If you sort the array, the complexity is O(nlogn). But by using a HashSet, we can achieve O(n) (Linear Time).
//The Technical Strategy
//
//    Storage: Put all numbers into a HashSet. This gives us O(1) lookup time.
//
//    The "Start" Check: Iterate through the numbers. A number x is the start of a sequence only if x - 1 is NOT in the set.
//
//    The Counting: If it is a start, use a while loop to see how far the sequence goes (x + 1, x + 2...).
//
//    Global Max: Keep track of the longest sequence found so far.
import java.util.*;

public class SequenceBoss {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive Sequence: " + longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        // 1. Put everything in a set for O(1) lookups
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;
        // 2. Iterate through the original array
        for (int num : numSet) {
            // 3. Logic: Check if 'num' is the START of a sequence
            // (If num-1 exists, this isn't the start!)
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // 4. Count how long this sequence lasts
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}