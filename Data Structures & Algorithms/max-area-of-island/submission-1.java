class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxarea = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    int area = dfs(i,j,visited,grid);
                    maxarea = Math.max(maxarea,area);
                }
            }
        }
        return maxarea;
    }

    private int dfs(int row,int col,boolean[][] visited,int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        visited[row][col] = true;
        int[] dr = {-1,0,1,0};
        int[]dc = {0,-1,0,1};
        int area = 1;
        for(int k = 0;k < 4;k++){
            int nr = row + dr[k];
            int nc = col + dc[k];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1 && !visited[nr][nc]){
                area += dfs(nr,nc,visited,grid);
            }
        }
        return area;
    }
}
