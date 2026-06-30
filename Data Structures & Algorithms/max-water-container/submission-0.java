class Solution {
    public int maxArea(int[] heights) {
        //two pointers left and right 
        //pick min height
        int left = 0;
        int right = heights.length-1;
        int maxarea = 0;
        while(left < right){
            int width = right-left;
            int minHeight = Math.min(heights[left],heights[right]);
            int area = width * minHeight;
            maxarea = Math.max(maxarea,area);
            if(heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxarea;
    }
}
