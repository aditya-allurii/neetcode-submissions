class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int islands = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    islands++;
                    dfs(i,j,grid,visited);
                }
            }
        }
        return islands;
    }
    private void dfs(int row,int col,char[][] grid,boolean[][] visited){
        int m = grid.length;
        int n = grid[0].length;
        if(row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || grid[row][col] == '0'){
            return;
        }
        visited[row][col] = true;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        for(int k = 0;k < 4;k++){
            int nr = row + dr[k];
            int nc = col + dc[k];
            dfs(nr,nc,grid,visited);
        }
    }
}
