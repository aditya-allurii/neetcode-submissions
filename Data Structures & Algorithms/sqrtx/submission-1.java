class Solution {
    public int mySqrt(int x) {
        int ans = 0;
        int start = 0;
        int end = x;
        while(start <= end){
            int mid = start + (end - start)/2;
            long sqrt = (long) mid * mid;
            if(sqrt == x){
                return mid;
            }else if(sqrt < x){
                ans = mid;
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return ans;
    }
}