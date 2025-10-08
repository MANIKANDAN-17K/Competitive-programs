class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int col1 = 1;

        // Step 1: Mark
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) col1 = 0; // Check first column separately
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 2: Apply markers (bottom-up to avoid overwriting)
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col1 == 0) matrix[i][0] = 0;
        }
    }
}
