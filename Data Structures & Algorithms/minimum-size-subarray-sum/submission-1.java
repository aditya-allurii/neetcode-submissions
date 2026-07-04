class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minlen = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int right = 0;right < nums.length;right++){
            sum = sum + nums[right];
            while(sum >= target){
                minlen = Math.min(minlen,right - left + 1);
                sum = sum - nums[left];
                left++;
            }
        }
        if(minlen == Integer.MAX_VALUE){
            return 0;
        }
        return minlen;
        //return minlen == Integer.MAX_VALUE ? 0: minlen;
    }
}