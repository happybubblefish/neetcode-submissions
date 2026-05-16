class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] alt = new boolean[rows][cols];

        for(int i = 0; i < rows; i++) {
            dfs(heights, i, 0, pac, heights[i][0]);
            dfs(heights, i, cols - 1, alt, heights[i][cols - 1]);
        }

        for(int i = 0; i < cols; i++) {
            dfs(heights, 0, i, pac, heights[0][i]);
            dfs(heights, rows - 1, i, alt, heights[rows - 1][i]);
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
        if(i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || visited[i][j]) {
            return;
        }

        if(heights[i][j] < preVal) {
            return;
        }

        visited[i][j] = true;

        for(int[] d : dirs) {
            int nr = i + d[0], nc = j + d[1];

            dfs(heights, nr, nc, visited, heights[i][j]);
        }
    }
}
