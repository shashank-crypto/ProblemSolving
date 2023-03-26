class Solution {

    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};
    int matrixRows;
    int matrixCols;

    public boolean isSafe(int row, int col) {
        return (row >= 0 && row < matrixRows && col >= 0 && col < matrixCols);
    }

    public int helper(int[][] matrix, int[][] dp, int row, int col) {
        int pathLength = 1;
        // if (!isSafe(row, col)) return 0;
        if (dp[row][col] != 0) return dp[row][col];
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            if (isSafe(nextRow, nextCol) && matrix[nextRow][nextCol] > matrix[row][col]) {
                pathLength = Math.max(pathLength, 1 + helper(matrix, dp, nextRow, nextCol));
            }
        }
        dp[row][col] = pathLength;
        return dp[row][col];
    }

    public int longestIncreasingPath(int[][] matrix) {
        this.matrixRows = matrix.length;
        this.matrixCols = matrix[0].length;
        int[][] longestPathMatrix = new int[matrix.length][matrix[0].length];
        int longestPath = 1;
        for (int row = 0; row < matrixRows; row++) {
            for (int col = 0; col < matrixCols; col++) {
                if (longestPathMatrix[row][col] == 0) {
                    longestPath = Math.max(longestPath, helper(matrix, longestPathMatrix, row, col));
                }
            }
        }
        return longestPath;
    }
}