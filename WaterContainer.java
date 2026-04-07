/* 2. Moderate: Container With Most Water

Concept: Two-Pointer Technique (Optimization)
The Challenge: You have an array height. Each element represents a vertical line. Find two lines that, together with the x-axis, form a container that holds the most water.

The Logic:
Using "Brute Force" (checking every pair) is slow O(n2). Instead, use Two Pointers:

    Start one pointer at the left and one at the right.

    Calculate the area: Width * Minimum Height.

    The Logic Move: To find a bigger area, you must move the pointer that is shorter. Moving the taller one won't help because the water level is limited by the shorter side!*/



public class WaterContainer {
    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max Water: " + maxArea(heights));
    }

    public static int maxArea(int[] height) {
        int maxW = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            maxW = Math.max(maxW, width * h);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxW;
    }
}