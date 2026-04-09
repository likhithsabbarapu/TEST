// Flood Fill
//
//Concept: Recursion / Depth-First Search (DFS).
//The Challenge: Imagine the "Paint Bucket" tool in Photoshop. Given a 2D grid (image), a starting pixel (sr, sc), and a color, change the color of that pixel and all connected pixels of the same original color.
//
//The Logic:
//This is a "recursive" problem.
//
//    Change the starting pixel's color.
//
//    Look at its neighbors (Up, Down, Left, Right).
//
//    If a neighbor has the original color, repeat the process for that neighbor.
//
//    This continues until you've "flooded" the entire connected area.
import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, newColor = 2;

        fill(image, sr, sc, newColor);

        for (int[] row : image) System.out.println(Arrays.toString(row));
    }

    public static void fill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) dfs(image, sr, sc, color, newColor);
    }

    private static void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != color) {
            return;
        }
        image[r][c] = newColor;
        dfs(image, r - 1, c, color, newColor); // Up
        dfs(image, r + 1, c, color, newColor); // Down
        dfs(image, r, c - 1, color, newColor); // Left
        dfs(image, r, c + 1, color, newColor); // Right
    }
}