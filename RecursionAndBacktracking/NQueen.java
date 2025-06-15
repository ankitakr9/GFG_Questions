// Java program to find all solutions of the N-Queens problem
// using backtracking and pruning

import java.util.ArrayList;
import java.util.List;

class NQueen {

    // Utility function for solving the N-Queens
    // problem using backtracking.
    static void nQueenUtil(int j, int n, ArrayList<Integer> board, boolean[] rows,
			boolean[] diag1, boolean[] diag2, ArrayList<ArrayList<Integer>> res) {

        if (j > n) {
            // A solution is found
            res.add(new ArrayList<>(board));
            return;
        }

        for (int i = 1; i <= n; ++i) {
            if (!rows[i] && !diag1[i + j] && !diag2[i - j + n]) {

                // Place queen
                rows[i] = diag1[i + j] = diag2[i - j + n] = true;
                board.add(i);

                // Recurse to the next column
                nQueenUtil(j + 1, n, board, rows, diag1, diag2, res);

                // Remove queen (backtrack)
                board.remove(board.size() - 1);
                rows[i] = diag1[i + j] = diag2[i - j + n] = false;
            }
        }
    }

    // Solves the N-Queens problem and returns
    // all valid configurations.
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> board = new ArrayList<>();

        // Rows occupied
        boolean[] rows = new boolean[n + 1];

        // Major diagonals (row + j) and Minor diagonals (row - col + n)
        boolean[] diag1 = new boolean[2 * n + 1];
        boolean[] diag2 = new boolean[2 * n + 1];

        // Start solving from the first column
        nQueenUtil(1, n, board, rows, diag1, diag2, res);
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        ArrayList<ArrayList<Integer>> res = nQueen(n);

        for (ArrayList<Integer> solution : res) {
            System.out.print("[");
            for (int i = 0; i < solution.size(); i++) {
                System.out.print(solution.get(i));
                if (i != solution.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println("]");
        }
    }
}