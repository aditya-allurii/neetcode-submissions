class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int minsum = nums[0];
        int maxsum = nums[0];
        int currentmin = 0;
        int currentmax = 0;

        for(int i = 0;i < nums.length;i++){
            currentmax = Math.max(currentmax+nums[i],nums[i]);
            maxsum = Math.max(maxsum,currentmax);
            currentmin = Math.min(currentmin+nums[i],nums[i]);
            minsum = Math.min(minsum,currentmin);
            total+=nums[i];
        }
        if(maxsum < 0){
            return maxsum;
        }
        return Math.max(maxsum,total-minsum);
    }
}