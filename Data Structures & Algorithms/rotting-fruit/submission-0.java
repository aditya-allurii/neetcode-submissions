class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[] {i,j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int minutes = 0;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        while(!queue.isEmpty() && fresh > 0){
            int size = queue.size();
            for(int i = 0;i < size;i++){
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                for(int k = 0;k < 4;k++){
                    int nr = row + dr[k];
                    int nc = col + dc[k];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        queue.offer(new int[] {nr,nc});
                    }
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}
