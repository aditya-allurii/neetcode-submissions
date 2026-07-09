class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int left = 0;
        for(int right = 0;right < n;right++){
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[right]){
                dq.pollLast();
            }
            dq.offerLast(right);
            if(dq.peekFirst() < left){
                dq.pollFirst();
            }
            if(right >= k-1){//window formation
                ans[left] = nums[dq.peekFirst()];
                left++;
            }
        }
        return ans;
    }
}
