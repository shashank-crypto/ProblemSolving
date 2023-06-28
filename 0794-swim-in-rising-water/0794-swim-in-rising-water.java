class WaterLevel {
    int level; 
    int row;
    int col;

    WaterLevel(int level, int row, int col) {
        this.level = level;
        this.row = row;
        this.col = col;
    }
}

class Solution {

    int totalRows;
    int totalCols;

    int[] nextRow = {-1, 0, 1, 0};
    int[] nextCol = {0, -1, 0, 1};

    public boolean isValid(int row, int col) {
        if (row < 0 || row >= totalRows || col < 0 || col >= totalCols) return false;
        return true;
    }

    public int swimInWater(int[][] grid) {
        this.totalRows = grid.length;
        this.totalCols = grid.length;
        PriorityQueue<WaterLevel> pq = new PriorityQueue<>((a,b) -> a.level - b.level);
        pq.add(new WaterLevel(grid[0][0], 0, 0));
        grid[0][0] = -1;
        while (!pq.isEmpty()) {
            WaterLevel minlevel = pq.poll();
            if (minlevel.row == totalRows - 1 && minlevel.col == totalCols - 1) return minlevel.level;
            for (int i = 0; i < 4; i++) {
                int newRow = minlevel.row + nextRow[i];
                int newCol = minlevel.col + nextCol[i];
                if (isValid(newRow, newCol) && grid[newRow][newCol] != -1) {
                    int waterLevel = Math.max(grid[newRow][newCol], minlevel.level);
                    WaterLevel nextLevel = new WaterLevel(waterLevel, newRow, newCol);
                    grid[newRow][newCol] = -1;
                    pq.add(nextLevel);
                }
            }
        }
        return 0;
    }
}