///Complex: Unique Paths
///
/// Concept: Dynamic Programming (Grid Logic).
/// The Challenge: A robot is at the top-left corner of a m×n grid. It can only move Down or Right. How many unique paths are there to reach the bottom-right corner?
///
/// The Logic:
/// This is a classic "Grid" problem. To reach any square, the robot must have come from either the square above it or the square to its left.
///
///     Create a 2D array (a map of the grid).
///
///     The first row and first column are all 1 (there's only one way to go straight right or straight down).
///
///     For every other square: Paths = Paths from Above + Paths from Left.


import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println("Unique paths for 3x7 grid: " + countPaths(m, n));
    }

    public static int countPaths(int m, int n) {
        int[][] grid = new int[m][n];

        // Fill first column and row with 1
        for (int i = 0; i < m; i++) grid[i][0] = 1;
        for (int j = 0; j < n; j++) grid[0][j] = 1;

        // Fill the rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }

        return grid[m - 1][n - 1];
    }
}