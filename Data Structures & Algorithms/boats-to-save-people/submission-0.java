class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        int ans = 0;
        while(left <= right){
            int maxweight = people[left] + people[right];
            if(maxweight <= limit){
                left++;
                right--;
                ans++;
            }else {
                right--;
                ans++;
            }
        }
        return ans;
    }
}