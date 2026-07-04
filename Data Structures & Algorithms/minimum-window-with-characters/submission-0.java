class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        HashMap<Character, Integer> tmap = new HashMap<>();
        HashMap<Character, Integer> wmap = new HashMap<>();
        int left = 0;
        int matched = 0;
        String ans = "";
        for(char c : t.toCharArray()){
            tmap.put(c,tmap.getOrDefault(c,0)+1);
        }
        for(int right = 0;right < s.length();right++){
            char rightchar = s.charAt(right);
            wmap.put(rightchar,wmap.getOrDefault(rightchar,0)+1);

            if(tmap.containsKey(rightchar) && tmap.get(rightchar).equals(wmap.get(rightchar))){
                matched++;
            }
            while(matched == tmap.size()){
                if(ans.equals("") || right - left + 1 < ans.length()){
                    ans = s.substring(left,right+1);
                }
                char leftchar = s.charAt(left);
                wmap.put(leftchar,wmap.getOrDefault(leftchar,0)-1);
                if(tmap.containsKey(leftchar) && wmap.get(leftchar) < tmap.get(leftchar)){
                    matched--;
                }
                left++;
            }
        } 
        return ans;
    }
}
