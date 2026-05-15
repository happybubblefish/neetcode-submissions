class Solution {

    int[][] dirs = {
        { -1, 0 },
        { 1, 0 },
        { 0, -1 },
        { 0, 1 }
    };

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, max = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        int count = 1;

        grid[i][j] = 0;

        for(int[] d : dirs) {
            int r = i + d[0], c = j + d[1];

            count += dfs(grid, r, c);
        }

        return count;
    }
}
