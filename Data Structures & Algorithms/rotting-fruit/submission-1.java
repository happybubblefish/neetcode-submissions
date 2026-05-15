class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> queue = new LinkedList<>();
        int rows = grid.length, cols = grid[0].length, fresh = 0, step = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{ i, j });
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[][] dirs = {
            { -1, 0 },
            { 1, 0 },
            { 0, -1 },
            { 0, 1 }
        };

        while(!queue.isEmpty() && fresh > 0) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int[] loc = queue.poll();
                int r = loc[0], c = loc[1];

                for(int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length) {
                        continue;
                    }

                    if(grid[nr][nc] != 1) {
                        continue;
                    }

                    grid[nr][nc] = 2;
                    fresh--;
                    queue.offer(new int[]{ nr, nc });
                }
            }

            step++;
        }

        return fresh > 0 ? -1 : step;
    }
}
