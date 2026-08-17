class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int perimeter = 0;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,-1,0,1};
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 1){
                    for(int k = 0;k < 4;k++){
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if(nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] == 0){
                            perimeter++;
                        }
                    }
                }
            }
        }
        return perimeter;
    }
}