class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int islands = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    islands++;
                    dfs(i,j,visited,grid);
                }
            }
        }
        return islands;
    }
    private void dfs(int row,int col,boolean[][] visited,char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        visited[row][col] = true;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,-1,0,1};
        for(int k = 0;k < 4;k++){
            int nr = row + dr[k];
            int nc = col + dc[k];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1' && !visited[nr][nc]){
                dfs(nr,nc,visited,grid);
            }
        }
    }
}
