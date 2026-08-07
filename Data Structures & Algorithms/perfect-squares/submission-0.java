class Solution {
    public int numSquares(int n) {
        int m = (int)Math.sqrt(n);

        int[] length = new int[m];
        for(int i = 0;i < m;i++){
            length[i] = (i+1) * (i+1);
        }
        int[][] dp = new int[m+1][n+1];

        for(int i = 0;i < m+1;i++){
            for(int j = 0;j < n+1;j++){
                if(i == 0){
                    dp[i][j] = Integer.MAX_VALUE-1;
                }
                if(j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1;i < m+1;i++){
            for(int j =1;j < n+1;j++){
                if(length[i-1] <= j){
                    dp[i][j] = Math.min(1 + dp[i][j-length[i-1]],dp[i-1][j]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[m][n] == Integer.MAX_VALUE - 1 ? -1 : dp[m][n];
    }
}