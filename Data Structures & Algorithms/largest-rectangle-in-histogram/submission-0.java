class Solution {
    public int largestRectangleArea(int[] heights) {
        //bruteforce
        int n = heights.length;
        int maxarea = 0;
        for(int i = 0;i < n;i++){
            int h = heights[i];
            for(int j = i;j < n;j++){
                h = Math.min(h,heights[j]);
                int width = j - i + 1;
                int area = h * width;
                maxarea = Math.max(maxarea,area);
            }
        }
        return maxarea;
    }
}
