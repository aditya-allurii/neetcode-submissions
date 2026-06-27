class Solution {
    public int[] productExceptSelf(int[] nums) {
        int leftpro = 1;
        int[] ans = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            ans[i] = leftpro;
            leftpro = leftpro * nums[i];
        }
        int rightpro = 1;
        for(int i = nums.length-1;i>=0;i--){
            ans[i] = ans[i] * rightpro;
            rightpro = rightpro * nums[i];
        }
        return ans;
    }
}  
