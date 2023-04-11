class Solution {

    int[] dx = { -1, 0, 0, 1};
    int[] dy = { 0, 1, -1, 0};

    int totalRows;
    int totalCols;

    private boolean isSafe(int row, int col) {
        if (row >= 0 && row < totalRows && col >= 0 && col < totalCols) return true;
        return false;
    }

    public void dfs(int[][] heights, int row, int col, boolean[][] visited) {
        visited[row][col] = true;
        for (int i = 0; i < 4; i++ ) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            if (isSafe(newRow, newCol) && !visited[newRow][newCol] && heights[newRow][newCol] >= heights[row][col]) {
                dfs(heights, newRow, newCol, visited);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        totalRows = heights.length;
        totalCols = heights[0].length;
        // first get the pacific matrix
        // then get the atlantic matrix
        // finally get the intersection
        boolean[][] pacific = new boolean[totalRows][totalCols];
        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                if (!pacific[row][col] && (row == 0 || col == 0))
                    dfs(heights, row, col, pacific);
            }
        }


        boolean[][] atlantic = new boolean[totalRows][totalCols];
        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                if (!atlantic[row][col] && (row == totalRows - 1 || col == totalCols - 1)) {
                    dfs(heights, row, col, atlantic);
                }
            }
        }

        List<List<Integer>> result = new LinkedList<>();
        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                if (pacific[row][col] && atlantic[row][col]) {
                    List<Integer> coordinates = Arrays.asList(row, col);
                    result.add(coordinates);
                }
            }
        }

        return result;

    }
}