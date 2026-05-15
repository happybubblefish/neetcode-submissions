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
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];

            for(int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length) {
                    continue;
                }

                if(grid[nr][nc] != Integer.MAX_VALUE) {
                    continue;
                }

                grid[nr][nc] = grid[r][c] + 1;
                queue.offer(new int[]{ nr, nc });
            }
        }
    }
}
