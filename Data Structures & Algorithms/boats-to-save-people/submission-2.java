class Solution {
    public int numRescueBoats(int[] people, int limit) {
        if(people.length ==0 || people == null){
            return 0;
        }
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
                //or simply only left++
            }else {
                right--;
                ans++;
            }
        }
        return ans;
    }
}