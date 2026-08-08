class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for(int stone : stones){
            sum += stone;
        }
        boolean[][] dp = subsetsum(stones,sum,n);
        int min = Integer.MAX_VALUE;
        for(int j = 0;j<= sum/2;j++){
            if(dp[n][j]){
                min = Math.min(min,sum-2*j);
            }
        }
        return min;
    }

    boolean[][] subsetsum(int[] nums,int sum,int n){
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i = 0;i < n+1;i++){
            for(int j = 0;j < sum+1;j++){
                if(i == 0){
                    dp[i][j] = false;
                }
                if(j == 0){
                    dp[i][j] = true;
                }
            }
        }

        for(int i = 1;i < n + 1;i++){
            for(int j = 1;j < sum+1;j++){
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp;
    }
}