class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        return lcs(text1,text2,m,n);
    }

    private int lcs(String x,String y,int m,int n){
        int[][] dp = new int[m + 1][n + 1];
        //initialization
        // for(int i = 0;i < m + 1;i++){
        //     for(int j = 0;j < n + 1;j++){
        //         if(i == 0 || j == 0){
        //             dp[i][j] = 0;
        //         }
        //     }
        // }

        //top-down
        for(int i = 1;i < m + 1;i++){
            for(int j = 1;j < n + 1;j++){
                if(x.charAt(i-1) == y.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }
}
