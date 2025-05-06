// Java program to rotate a matrix in anticlockwise
// direction by forming cycles

import java.util.*;

class RotateMatrix90Deg {
    static void rotateMatrix(int[][] mat) {
        int n = mat.length;

        // Consider all cycles one by one
        for (int i = 0; i < n / 2; i++) {

            // Consider elements in group of 4
            // as P1, P2, P3 & P4 in current square
            for (int j = i; j < n - i - 1; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][n - 1 - i];
                mat[j][n - 1 - i] = mat[n - 1 - i][n - 1 - j];
                mat[n - 1 - i][n - 1 - j] = mat[n - 1 - j][i];
                mat[n - 1 - j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        rotateMatrix(mat);

        // Print the rotated matrix
        for (int[] row : mat) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}