// Java program to perform spiral order
// traversal of a matrix
import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {
    static List<Integer> spirallyTraverse(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        ArrayList<Integer> res = new ArrayList<>();

        // Initialize boundaries
        int top = 0, bottom = m - 1, left = 0, right = n - 1;

        // Iterate until all elements are printed
        while (top <= bottom && left <= right) {

            // Print top row from left to right
            for (int i = left; i <= right; ++i) {
                res.add(mat[top][i]);
            }
            top++;

            // Print right column from top to bottom
            for (int i = top; i <= bottom; ++i) {
                res.add(mat[i][right]);
            }
            right--;

            // Print bottom row from right to left (if exists)
            if (top <= bottom) {
                for (int i = right; i >= left; --i) {
                    res.add(mat[bottom][i]);
                }
                bottom--;
            }

            // Print left column from bottom to top (if exists)
            if (left <= right) {
                for (int i = bottom; i >= top; --i) {
                    res.add(mat[i][left]);
                }
                left++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4}, 
                       {5, 6, 7, 8}, 
                       {9, 10, 11, 12}, 
                       {13, 14, 15, 16}};

        List<Integer> res = spirallyTraverse(mat);
        for (int ele : res) {
            System.out.print(ele + " ");
        }
    }
}