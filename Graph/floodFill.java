// Java implementation of Flood Fill Algorithm
// using BFS
import java.util.*;

class floodFill {

    // Directions for traversing in 4-neighbor cells
    private static final int[][] directions = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public static int[][] floodFill(int[][] image,
                                    int sr, int sc, 
                                    int newColor) {

        // If the starting pixel already has the new color
        if (image[sr][sc] == newColor) {
            return image;
        }

        int oldColor = image[sr][sc];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});

        // Change the color of the starting pixel
        image[sr][sc] = newColor;

        while (!q.isEmpty()) {
            int[] front = q.poll();
            int x = front[0], y = front[1];

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                // Check boundary conditions and color match
                if (nx >= 0 && nx < image.length && 
                    ny >= 0 && ny < image[0].length && 
                    image[nx][ny] == oldColor) {

                    // Change the color and enqueue
                    image[nx][ny] = newColor;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return image;
    }

    public static void main(String[] args) {

    // Define the input 2D image as a matrix where 
    // each element represents a pixel's color
    int[][] image = {
        {1, 1, 1, 0},
        {0, 1, 1, 1},
        {1, 0, 1, 1}
    };

    // sr: starting row index, sc: starting column 
    // index for the flood fill
    int sr = 1, sc = 2;

    // newColor: the color that we want to fill the 
    // connected component with
    int newColor = 2;

    // Call the floodFill function to apply the 
    // newColor starting from (sr, sc)
    int[][] result = floodFill(image, sr, sc, newColor);

    // Print the updated image after flood fill
    for (int[] row : result) {         
        for (int pixel : row) {       
            System.out.print(pixel + " ");  
        }
        // Move to the next line after each row
        System.out.println();        
    }
    
}

}
