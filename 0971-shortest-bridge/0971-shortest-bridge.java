class Coordinates {
    int row;
    int col;

    Coordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {

    int[] nextRow = {-1, 0, 1, 0};
    int[] nextCol = {0, 1, 0, -1};
    int totalRows;
    int totalCols;

    public boolean isValid(int row, int col) {
        if (row < 0 || row >= totalRows || col < 0 || col >= totalCols) return false;
        return true;
    }


    public void markIsland(int row, int col, int[][] grid, Queue<Coordinates> islandBlocks) {
        grid[row][col] = 2;
        islandBlocks.add(new Coordinates(row, col));
        for (int i = 0; i < 4; i++) {
            int newRow = row + nextRow[i];
            int newCol = col + nextCol[i];
            if (isValid(newRow, newCol) && grid[newRow][newCol] == 1) {
                markIsland(newRow, newCol, grid, islandBlocks);
            }
        }
    }

    public int shortestBridge(int[][] grid) {
        this.totalRows = grid.length;
        this.totalCols = grid.length;
        Queue<Coordinates> firstIsland = new LinkedList<>();
        boolean done = false;
        for (int i = 0; i < totalRows && !done; i++) {
            for (int j = 0; j < totalCols && !done; j++) {
                if (grid[i][j] == 1) {
                    markIsland(i, j, grid, firstIsland);
                    done = true;
                }
            }
        }
        int distance = 0;
        while (!firstIsland.isEmpty()) {
            int qSize = firstIsland.size();
            for (int j = 0; j < qSize; j++) {
                Coordinates block = firstIsland.poll();
                for (int i = 0; i < 4; i++) {
                    int newRow = block.row + nextRow[i];
                    int newCol = block.col + nextCol[i];
                    if (isValid(newRow, newCol) && grid[newRow][newCol] == 0) {
                        grid[newRow][newCol] = 2;
                        firstIsland.add(new Coordinates(newRow, newCol));
                    }
                    else if (isValid(newRow, newCol) && grid[newRow][newCol] == 1)
                        return distance;
                }
            }
            distance++;
        }
        return -1;
    }
}