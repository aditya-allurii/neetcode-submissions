class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] freq = new int[26];
        for(int i = 0;i < order.length();i++){
            freq[order.charAt(i) - 'a'] = i;
        }
        for(int i = 0;i < words.length - 1;i++){
            String w1 = words[i];
            String w2 = words[i+1];
            int len = Math.min(w1.length(),w2.length());
            boolean different = false;
            for(int j = 0;j < len;j++){
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if(c1 != c2){
                    different = true;
                    if(freq[c1 - 'a'] > freq[c2 - 'a']){
                        return false;
                    }
                    break;
                }
            }
            if(!different && w1.length() > w2.length()){
                return false;
            }
        }
        return true;
    }
}