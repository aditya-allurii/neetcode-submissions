class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 0){
                    queue.offer(new int[] {i,j});
                }
            }
        }
        int[] dr = {-1,0,1,0};
        int[] dc = {0,-1,0,1};
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            for(int k = 0;k < 4;k++){
                int nr = row + dr[k];
                int nc = col + dc[k];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == Integer.MAX_VALUE){
                    grid[nr][nc] = 1 + grid[row][col];
                    queue.offer(new int[] {nr,nc});
                }
            }
        }
    }
}
