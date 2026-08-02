class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        if(sum % 2 != 0){
            return false;
        }else {
            return subsetSum(nums,sum/2,n);
        }
    }

    private boolean subsetSum(int[] nums,int sum,int n){

        boolean dp[][] = new boolean[n + 1][sum + 1];

        //n=i,sum=j
        for(int i = 0;i < n + 1;i++){
            for(int j = 0;j < sum + 1;j++){
                if(i == 0){
                    dp[i][j] = false;//empty array with sum given rather than 0->no subsets can be found
                }
                if(j == 0){
                    dp[i][j] = true;//non empty array and with sum = 0 and also emptyarray+sum=0 true
                }
            }
        }

        for(int i = 1;i < n + 1;i++){
            for(int j = 1;j < sum + 1;j++){
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j - nums[i-1]] || dp[i-1][j];//add or dont add
                }else {
                    dp[i][j] = dp[i-1][j];//dont add
                }
            }
        }

        return dp[n][sum];
    }
}
