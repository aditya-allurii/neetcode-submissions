class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //edge case
        if(s1.length() > s2.length()){
            return false;
        }
        int[] s1count = new int[26];
        int[] windowcount = new int[26];
        int left = 0;
        for(int i = 0;i<s1.length();i++){
            s1count[s1.charAt(i) - 'a']++;
        }
        for(int right = 0;right < s2.length();right++){
            windowcount[s2.charAt(right) - 'a']++;
            if(right - left + 1 > s1.length()){
                windowcount[s2.charAt(left) - 'a']--;
                left++;
            }
            if(s1.length() == right - left + 1){
                if(Arrays.equals(s1count,windowcount)){
                    return true;
                }
            }
        }
        return false;
    }
}
