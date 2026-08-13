class Solution {
    public int numIslands(char[][] grid) {
        //bfs traversal

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int islands = 0;

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    islands++;
                    bfs(i,j,grid,visited);
                }
            }
        }
        
        return islands;
    }

    private void bfs(int row,int col,char[][] grid,boolean[][] visited){
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {row,col});
        visited[row][col] = true;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            for(int k = 0;k < 4;k++){
                int newrow = r + dr[k];
                int newcol = c + dc[k];

                if(newrow >= 0 && newrow < m && newcol >= 0 && newcol < n && grid[newrow][newcol] == '1' && !visited[newrow][newcol]){
                    visited[newrow][newcol] = true;
                    queue.offer(new int[] {newrow,newcol});
                }
            }
        }
    }
}
