class Solution {
    public int maxProduct(int[] nums) {
        int maxproduct = nums[0];
        int currentproduct = 1;

        for(int num : nums){
            currentproduct *= num;
            maxproduct = Math.max(maxproduct,currentproduct);
            if(currentproduct == 0){
                currentproduct = 1;
            }
        }
        currentproduct = 1;
        for(int right = nums.length-1;right >= 0;right--){
            currentproduct *= nums[right];
            maxproduct = Math.max(maxproduct,currentproduct);
            if(currentproduct == 0){
                currentproduct = 1;
            }
        }

        return maxproduct;
    }
}
