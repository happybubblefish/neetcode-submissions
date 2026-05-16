class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> queue = new LinkedList<>();
        int rows = grid.length, cols = grid[0].length;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 0) {
                    queue.offer(new int[]{ i, j });
                }
            }
        }

        int[][] dirs = {
            { -1, 0 },
            { 1, 0 },
            { 0, -1 },
            { 0, 1 }
        };

        while(!queue.isEmpty()) {
            int[] loc = queue.poll();
            int r = loc[0], c = loc[1];
            
            for(int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length) {
                    continue;
                }

                if(grid[nr][nc] == Integer.MAX_VALUE) {
                    grid[nr][nc] = grid[r][c] + 1;
                    queue.offer(new int[]{ nr, nc });
                }
            }
        }
    }
}
