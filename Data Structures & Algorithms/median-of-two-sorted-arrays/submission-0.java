class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] ans = new int[m + n];
        for(int i = 0;i < m;i++){
            ans[i] = nums1[i];
        }
        for(int i = 0;i < n;i++){
            ans[m + i] = nums2[i];
        }
        Arrays.sort(ans);
        if(ans.length %2 == 1){
            return ans[ans.length/2];
        }else {
            return (ans[ans.length / 2] + ans[ans.length/ 2 - 1]) / 2.0;

        }
    }
}
