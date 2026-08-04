class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        if(Math.abs(target) > sum){
            return 0;
        }
        if((sum + target) % 2 != 0){
            return 0;
        }
        int subsum = (target + sum) / 2;
        return subsetsum(nums,subsum,n);
    }
    public int subsetsum(int[] nums,int sum,int n){
        int[][] dp = new int[n+1][sum+1];
        dp[0][0] = 1;
        for(int j = 1;j < sum+1;j++){
            dp[0][j] = 0;
        }

        for(int i = 1;i<n+1;i++){
            for(int j = 0;j<sum+1;j++){
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
