class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 0;
        for(int num : piles){
            end = Math.max(end,num);
        }
        while(start <= end){
            int mid = start + (end - start)/2;
            long speed = 0;
            for(int num : piles){
                speed += (num + mid - 1)/mid;
            }
            if(speed > h){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return start;
    }
}
