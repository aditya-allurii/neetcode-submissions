class Solution {
    public String minWindow(String s, String t) {
        //edge case
        if(t.length() > s.length()){
            return "";
        }

        int[] tmap = new int[128];//ascii fomr 0-127
        int[] wmap = new int[128];

        //lets write first tmap
        //so we need size of tmap we introduce required which gives it length,like if its freq is 0 we need the char like so gives total length which is equal to total chars in it
        int required = 0;
        for(char c : t.toCharArray()){
            if(tmap[c] == 0){
                required++;
            }
            tmap[c]++;
        }
        int left = 0;
        int matched = 0;
        String ans = "";
        //now window map
        for(int right = 0;right < s.length();right++){
            char rightchar = s.charAt(right);
            wmap[rightchar]++;

            //now check freq 
            if(tmap[rightchar] > 0 && wmap[rightchar] == tmap[rightchar]){
                matched++;
            }
            while(matched == required){
                if(ans.equals("") || right - left + 1 < ans.length()){
                    ans = s.substring(left,right+1);
                }
                //remove leftchar to get min ans
                char leftchar = s.charAt(left);
                wmap[leftchar]--;
                //condition which fails
                if(tmap[leftchar] > 0 && wmap[leftchar] < tmap[leftchar]){
                    matched--;
                }
                left++;
            }
        }
        return ans;
    }
}
