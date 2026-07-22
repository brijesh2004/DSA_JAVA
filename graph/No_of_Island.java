class No_of_Island{
    private void solve(int i, int j, int m, int n, char[][] grid, int[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0' || visited[i][j] == 1)
            return;
        visited[i][j] = 1;

        solve(i - 1, j, m, n, grid, visited);
        solve(i + 1, j, m, n, grid, visited);
        solve(i, j - 1, m, n, grid, visited);
        solve(i, j + 1, m, n, grid, visited);
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    solve(i, j, m, n, grid, visited);
                    ans++;
                }
            }
        }
        return ans;
    }
}