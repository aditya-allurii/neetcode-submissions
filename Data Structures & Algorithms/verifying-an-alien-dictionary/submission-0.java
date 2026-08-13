class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] freq = new int[26];
        for(int i = 0;i <order.length();i++){
            freq[order.charAt(i) - 'a'] = i;
        }
        for(int i = 0;i <words.length-1;i++){
            String word1 = words[i];
            String word2 = words[i+1];
            int len = Math.min(word1.length(),word2.length());
            boolean different = false;
            for(int j = 0;j < len;j++){
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if(c1 != c2){
                    different = true;
                    if(freq[c1 - 'a'] > freq[c2 - 'a']){
                        return false;
                    }
                    break;
                }
            }
            if(!different && word1.length() > word2.length()){
                return false;
            }
        }
        return true;
    }
}