class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxarea = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    int area = dfs(grid,i,j,visited);
                    maxarea = Math.max(maxarea,area);
                }
            }
        }

        return maxarea;
    }

    private int dfs(int[][] grid,int row,int col,boolean[][] visited){
        int m = grid.length;
        int n = grid[0].length;
        if(row < 0 || row >= m || col < 0 || col >= n || visited[row][col]){
            return 0;
        }
        if(grid[row][col] == 0){
            return 0;
        }

        visited[row][col] = true;
        int area = 1;
        area += dfs(grid,row-1,col,visited);
        area += dfs(grid,row+1,col,visited);
        area += dfs(grid,row,col-1,visited);
        area += dfs(grid,row,col+1,visited);

        return area;
    }
}
