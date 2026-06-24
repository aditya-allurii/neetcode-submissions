class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = nums.length-1;
        while(one <= two){
            if(nums[one] == 0){
                int temp = nums[zero];
                nums[zero] = nums[one];
                nums[one] = temp;
                zero++;
                one++;
            }
            else if(nums[one] == 1){
                one++;
            }else {
                int temp = nums[one];
                nums[one] = nums[two];
                nums[two] = temp;
                two--;
            }
        }
    }
}