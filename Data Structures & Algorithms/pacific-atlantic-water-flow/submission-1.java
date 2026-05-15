class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int rows = heights.length, cols = heights[0].length;

        boolean[][] pac = new boolean[rows][cols];
        boolean[][] alt = new boolean[rows][cols];

        for(int r = 0; r < rows; r++) {
            dfs(heights, r, 0, pac, heights[r][0]);
            dfs(heights, r, cols - 1, alt, heights[r][cols - 1]);
        }

        for(int c = 0; c < cols; c++) {
            dfs(heights, 0, c, pac, heights[0][c]);
            dfs(heights, rows - 1, c, alt, heights[rows - 1][c]);
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(pac[i][j] && alt[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }

        return res;
    }

    int[][] dirs = {
        { -1, 0 },
        { 1, 0 },
        { 0, -1 },
        { 0, 1 }
    };

    private void dfs(int[][] heights, int i, int j, boolean[][] visited, int preVal) {
        if(i < 0 || j < 0 || i >= heights.length || j >= heights[0].length) {
            return;
        }

        if(visited[i][j]) {
            return;
        }

        if(heights[i][j] < preVal) {
            return;
        }

        visited[i][j] = true;

        for(int[] d : dirs) {
            dfs(heights, i + d[0], j + d[1], visited, heights[i][j]);
        }
    }
}
