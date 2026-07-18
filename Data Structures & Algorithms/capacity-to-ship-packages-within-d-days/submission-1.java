class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = 0;
        int end = 0;
        for(int num : weights){
            start = Math.max(start,num);
            end = end + num;
        }
        while(start < end){
            int mid = start + (end - start)/2;
            int day = 1;
            int weight = 0;
            for(int num : weights){
                if(num + weight > mid){
                    day++;
                    weight = num;
                }else {
                    weight += num;
                }
            }
            if(day > days){
                start = mid + 1;
            }else {
                end = mid;
            }
        }
        return start;//or end
    }
}