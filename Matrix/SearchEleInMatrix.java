// Java program to search in the sorted matrix using
// binary search

class SearchEleInMatrix {

    // Function to search for x in the matrix using binary search
    static boolean searchMatrix(int[][] mat, int x) {
        int n = mat.length, m = mat[0].length;

        int lo = 0, hi = n * m - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            // Find row and column of element at mid index
            int row = mid / m;
            int col = mid % m;

            // If x is found, return true
            if (mat[row][col] == x)
                return true;

            // If x is greater than mat[row][col], search in
            // right half
            if (mat[row][col] < x)
                lo = mid + 1;

            // If x is less than mat[row][col], search in
            // left half
            else
                hi = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 5, 9}, {14, 20, 21}, {30, 34, 43}};
        int x = 14;

        if (searchMatrix(mat, x))
            System.out.println("true");
        else
            System.out.println("false");
    }
}

